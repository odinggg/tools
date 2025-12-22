# Gemini Code Assistant Context

This document provides context for the Gemini Code Assistant to understand the "tools" project.

## Project Overview

This is a multi-language project containing a collection of various small tools and utilities. The main components are a Java-based Spring Boot application and a standalone Python script for monitoring orders.

The project's description is "各种小工具" (various small tools).

### Core Technologies

*   **Java Application:**
    *   Java 1.8
    *   Spring Boot 2.1.1
    *   Maven
    *   Spring Web, WebSocket, AOP
    *   Selenium (for browser automation)
    *   Jackson (for JSON, YAML, XML, CSV)
*   **Python Script:**
    *   Python 3
    *   requests
    *   schedule
    *   google-generativeai

## Java Application Details

The Java application is the primary part of the repository, providing a web server and several distinct services.

### Key Features

*   **WeChat Integration:** A major feature is the integration with both standard WeChat and Work WeChat. It allows for message forwarding between the two, effectively enabling a multi-login solution for iOS users. It exposes REST endpoints to get a login QR code and check the login status.
*   **Bilibili Video Downloader:** A tool to download videos from Bilibili, utilizing the `aria2` download manager.
*   **Twitter Automation:** A service for bulk-following Twitter accounts.
*   **File Converters:** Utilities to convert files between formats (e.g., YML to Properties).
*   **PowerShell Scripts:** Includes PowerShell scripts for UI automation tasks like mouse clicking and screen capturing.
*   **Custom TCP Server:** The application starts a custom TCP server on port `12345`.

### Building and Running

The project is built using Maven.

*   **Build the project:**
    ```shell
    mvn clean install
    ```
*   **Run the application:**
    ```shell
    mvn spring-boot:run
    ```
The web server will start on port `9011` by default.

### Configuration

*   The main configuration is in `src/main/resources/application.yml`.
*   The active profile is set to `test` by default, but a `dev` profile exists in `src/main/resources/application-dev.yml`.
*   The `README.md` file contains specific YAML configuration blocks required for the Work WeChat integration.

## Python Order Monitor Script

Located in the `python/monitor/` directory, this is a standalone script for monitoring order statuses from an external API (`haokaapi.lot-ml.com`).

### Key Features

*   **Automated Login:** The script logs into the service to get an auth token.
*   **Captcha Solving:** It uses the Google Gemini API (`gemini-1.5-flash`) to automatically solve image captchas during the login process.
*   **Status Monitoring:** It periodically queries an API endpoint to check for changes in order statuses.
*   **Push Notifications:** When a status change is detected, it sends a push notification via the Bark app.

### Running the Script

1.  **Install dependencies:**
    ```shell
    pip install -r python/monitor/requirements.txt
    ```
2.  **Configure:** Create and fill out `python/monitor/config.ini` with credentials (`username`, `password`), the Gemini API key, and the Bark key.
3.  **Run:**
    ```shell
    python python/monitor/order_monitor.py
    ```
