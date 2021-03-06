#Start-Job -ScriptBlock {
$cSource = @'
using System;
using System.Drawing;
using System.Runtime.InteropServices;
using System.Windows.Forms;
public class Clicker
{
//https://msdn.microsoft.com/en-us/library/windows/desktop/ms646270(v=vs.85).aspx
[StructLayout(LayoutKind.Sequential)]
struct INPUT
{
    public int        type; // 0 = INPUT_MOUSE,
                            // 1 = INPUT_KEYBOARD
                            // 2 = INPUT_HARDWARE
    public MOUSEINPUT mi;
}

//https://msdn.microsoft.com/en-us/library/windows/desktop/ms646273(v=vs.85).aspx
[StructLayout(LayoutKind.Sequential)]
struct MOUSEINPUT
{
    public int    dx ;
    public int    dy ;
    public int    mouseData ;
    public int    dwFlags;
    public int    time;
    public IntPtr dwExtraInfo;
}

//This covers most use cases although complex mice may have additional buttons
//There are additional constants you can use for those cases, see the msdn page
const int MOUSEEVENTF_MOVED      = 0x0001 ;
const int MOUSEEVENTF_LEFTDOWN   = 0x0002 ;
const int MOUSEEVENTF_LEFTUP     = 0x0004 ;
const int MOUSEEVENTF_RIGHTDOWN  = 0x0008 ;
const int MOUSEEVENTF_RIGHTUP    = 0x0010 ;
const int MOUSEEVENTF_MIDDLEDOWN = 0x0020 ;
const int MOUSEEVENTF_MIDDLEUP   = 0x0040 ;
const int MOUSEEVENTF_WHEEL      = 0x0080 ;
const int MOUSEEVENTF_XDOWN      = 0x0100 ;
const int MOUSEEVENTF_XUP        = 0x0200 ;
const int MOUSEEVENTF_ABSOLUTE   = 0x8000 ;

const int screen_length = 0x10000 ;

//https://msdn.microsoft.com/en-us/library/windows/desktop/ms646310(v=vs.85).aspx
[System.Runtime.InteropServices.DllImport("user32.dll")]
extern static uint SendInput(uint nInputs, INPUT[] pInputs, int cbSize);

public static void LeftClickAtPoint(int x, int y)
{
    //Move the mouse
    INPUT[] input = new INPUT[3];
    input[0].mi.dx = x*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width);
    input[0].mi.dy = y*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height);
    input[0].mi.dwFlags = MOUSEEVENTF_MOVED | MOUSEEVENTF_ABSOLUTE;
    //Left mouse button down
    input[1].mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    //Left mouse button up
    input[2].mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(3, input, Marshal.SizeOf(input[0]));
}

public static void MoveTo(int x, int y)
{
    //Move the mouse
    INPUT[] input = new INPUT[1];
    input[0].mi.dx = x*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width);
    input[0].mi.dy = y*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height);
    input[0].mi.dwFlags = MOUSEEVENTF_MOVED | MOUSEEVENTF_ABSOLUTE;
    SendInput(1, input, Marshal.SizeOf(input[0]));
}

public static void ClickLeft()
{
    //Move the mouse
    INPUT[] input = new INPUT[2];
    //Left mouse button down
    input[0].mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    //Left mouse button up
    input[1].mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(2, input, Marshal.SizeOf(input[0]));
}

public static void DragClickAtPoint(int x, int y,int x1,int y1)
{
    //Move the mouse
    INPUT[] input = new INPUT[4];
    input[0].mi.dx = x*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width);
    input[0].mi.dy = y*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height);
    input[0].mi.dwFlags = MOUSEEVENTF_MOVED | MOUSEEVENTF_ABSOLUTE;
    //Left mouse button down
    input[1].mi.dwFlags = MOUSEEVENTF_LEFTDOWN;
    // move to pos
    input[2].mi.dx = x1*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Width);
    input[2].mi.dy = y1*(65535/System.Windows.Forms.Screen.PrimaryScreen.Bounds.Height);
    input[2].mi.dwFlags = MOUSEEVENTF_MOVED | MOUSEEVENTF_ABSOLUTE;
    //Left mouse button up
    input[3].mi.dwFlags = MOUSEEVENTF_LEFTUP;
    SendInput(4, input, Marshal.SizeOf(input[0]));
}
}
'@
Add-Type -TypeDefinition $cSource -ReferencedAssemblies System.Windows.Forms, System.Drawing
#Send a click at a specified point
#[Clicker]::LeftClickAtPoint(600, 600)
function Set-DragClickAtPoint
{
    [CmdletBinding()] Param(
        [Parameter(Mandatory = $True)]
        [Int32] $x,

        [Parameter(Mandatory = $True)]
        [Int32] $y,

        [Parameter(Mandatory = $True)]
        [Int32] $x1,

        [Parameter(Mandatory = $True)]
        [Int32] $y1
    )
    [Clicker]::DragClickAtPoint($x, $y, $x1, $y1)
}
function Set-LeftClickAtPoint
{
    [CmdletBinding()] Param(
        [Parameter(Mandatory = $True)]
        [Int32] $x,

        [Parameter(Mandatory = $True)]
        [Int32] $y
    )
    [Clicker]::MoveTo($x, $y)
    Start-Sleep -Seconds 3
    [Clicker]::ClickLeft()
}

#[Clicker]::DragClickAtPoint(6, 165,600,1200)
#[Clicker]::DragClickAtPoint(600, 600,600,1200)
#} | Receive-Job -Wait -AutoRemoveJob
Do
{
    #run screenshot function
    $xran = Get-Random -Maximum 5 -Minimum -5
    $yran = Get-Random -Maximum 5 -Minimum -5
    $timeran = Get-Random -Maximum 100 -Minimum -0
    Set-LeftClickAtPoint (330 + $xran) (800 + $yran)

    Start-Sleep -Milliseconds (2000 + $timeran)
}

#note that this will run once regardless if the specified time as passed
While ((Get-Date -Format "yyyy-MM-dd HH:mm:ss") -lt "2021-05-12 14:00:00")
