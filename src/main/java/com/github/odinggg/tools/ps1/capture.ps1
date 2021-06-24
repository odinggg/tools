#Start-Job -ScriptBlock {
    function Get-TimedScreenshot
    {
        [CmdletBinding()] Param(
            [Parameter(Mandatory = $True)]
            [ValidateScript({ Test-Path -Path $_ })]
            [String] $Path,

            [Parameter(Mandatory = $True)]
            [Int32] $Interval,

            [Parameter(Mandatory = $True)]
            [String] $EndTime,

            [Parameter(Mandatory = $True)]
            [String] $className,
            [Parameter(Mandatory = $True)]
            [String] $titleName
        )
        Try
        {
            [Reflection.Assembly]::LoadWithPartialName("System.Drawing")
            Add-Type @'
[DllImport("user32.dll")]
public static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);
[DllImport("User32.dll", EntryPoint = "FindWindow")]
public static extern IntPtr FindWindow(string lpClassName, string lpWindowName);
// https://docs.microsoft.com/zh-cn/windows/win32/api/winuser/nf-winuser-setwindowpos
[DllImport("User32.dll", EntryPoint = "SetWindowPos")]
public static extern bool SetWindowPos(IntPtr hWnd, IntPtr hWndInsertAfter,int x,int y,int cx,int cy,uint uFlags);
'@ -name “Win32ShowWindow” -namespace Win32API -PassThru
            $code4 = @'
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Runtime.InteropServices;
using System.Threading;
namespace test
{
    public class MyFindWindowRect2
    {
        [DllImport("user32.dll")]
        private static extern bool GetWindowRect(IntPtr hwnd, ref Rect lpRect);
        public struct Rect
        {
            public int Left;
            public int Top;
            public int Right;
            public int Bottom;
            public override String ToString()
            {
                return base.ToString() + "Left=" + this.Left + "  Top=" + this.Top + "  Right=" + this.Right + " Bottom=" + this.Bottom;
            }
        }
        public static Rect test(IntPtr avd,string lpClassName,string lpWindowName)
        {
            if (avd == IntPtr.Zero)
            {
                return new Rect();
            }
            else
            {
                Rect rect = new Rect();
                GetWindowRect(avd, ref rect);
				return rect;
            }
        }
    }
}
'@
            Add-Type -TypeDefinition $code4
            $myObj = New-Object test.MyFindWindowRect2

            $windowPtr = [Win32API.Win32ShowWindow]::FindWindow($className, $titleName)
            $isShow = [Win32API.Win32ShowWindow]::ShowWindow($windowPtr, 9)
            $isShow
            Start-Sleep -Seconds 3
            $isMove = [Win32API.Win32ShowWindow]::SetWindowPos($windowPtr, -1, 10, 10, 0, 0, 0x0001)
            $isMove
            Start-Sleep -Seconds 3
            $rect = $myObj::test($windowPtr, $className, $titleName)
            function screenshot([Drawing.Rectangle]$bounds, $path)
            {
                $bmp = New-Object Drawing.Bitmap $bounds.width, $bounds.height
                $graphics = [Drawing.Graphics]::FromImage($bmp)
                $graphics.CopyFromScreen($bounds.Location, [Drawing.Point]::Empty, $bounds.size)
                Write-Verbose "Saved screenshot to $FilePath. "
                $bmp.Save($path)

                $graphics.Dispose()
                $bmp.Dispose()
            }
            $rect
            $bounds = [Drawing.Rectangle]::FromLTRB($rect.Left, $rect.Top, $rect.Right, $rect.Bottom)
            Do
            {
                #get the current time and build the filename from it
                $Time = (Get-Date)

                [String]$FileName = "$( $Time.Month )"
                $FileName += '-'
                $FileName += "$( $Time.Day )"
                $FileName += '-'
                $FileName += "$( $Time.Year )"
                $FileName += '-'
                $FileName += "$( $Time.Hour )"
                $FileName += '-'
                $FileName += "$( $Time.Minute )"
                $FileName += '-'
                $FileName += "$( $Time.Second )"
                $FileName += '.png'

                #use join-path to add path to filename
                [String]$FilePath = (Join-Path $Path $FileName)

                #run screenshot function
                screenshot $bounds $FilePath

                Write-Verbose "Saved screenshot to $FilePath. Sleeping for $Interval seconds"

                Start-Sleep -Seconds $Interval
            }

            #note that this will run once regardless if the specified time as passed
            While ((Get-Date -Format "yyyy-MM-dd HH:mm:ss") -lt $EndTime)
        }
        Catch
        {
            Write-Error $Error[0].ToString() + $Error[0].InvocationInfo.PositionMessage
        }
    }
    $baseClassName = "Qt5QWindowIcon"
    $baseTitleName = "游戏王：决斗链接 - MuMu模拟器"
    $basePath = "D:\tmp\"
    Get-TimedScreenshot -Path $basePath -Interval 600 -EndTime $args[0] -className $baseClassName -titleName $baseTitleName
#} | Receive-Job -Wait -AutoRemoveJob
# powershell.exe -ExecutionPolicy Unrestricted -File "D:\tmp\qinha\Documents\powershell\无标题1.ps1"  "2021-05-11 19:00:00"
