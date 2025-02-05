# HKAselenium_Dynamic_Element_Handling_in_Automation

A. Project Overview
 
    This project demonstrates how to automate the interaction with dynamic elements on a webpage using Selenium WebDriver in Java. The script automates the process of navigating to a page with dynamic content, interacting with elements that load dynamically, and extracting content after the page has loaded.

B. Key Features

      B.1. Selenium WebDriver for browser automation.
      B.2. Explicit Wait to handle dynamic elements loading.
      B.3. ChromeDriver used as the WebDriver for automation.

C. Prerequisites

    Before running the automation script, ensure you have the following:
        C.1. Java (version 8 or higher).
        C.2. Maven (optional, if using for dependency management).
        C.3. Selenium WebDriver dependency added to your project.
        C.4. ChromeDriver compatible with your browser version.

D. Project Setup

    D.1. Clone the repository
       Clone this repository to your local machine:
          - git clone https://github.com/your-username/dynamic-elements-automation.git
    D.2. Install Dependencies
         Make sure you have Selenium WebDriver set up. You can add the Selenium dependency to your pom.xml if you are using Maven:
              <dependency>
                     <groupId>org.seleniumhq.selenium</groupId>
                     <artifactId>selenium-java</artifactId>
                     <version>4.0.0</version>
              </dependency>
              
         Alternatively, download the latest Selenium WebDriver JAR files and add them to your project classpath.

    D.3. Download ChromeDriver
         D.3.1 Download the ChromeDriver that matches your version of Google Chrome:
         D.3.2. Ensure that you update the path in the script with the correct location of the chromedriver.
                 - System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    D.4. Run the Script
         After setting up your environment and dependencies, you can run the DynamicElements.java file.
            - javac DynamicElements.java
            - java DynamicElements
         The script will navigate to this page and wait for dynamic content to load before printing the result to the console.

E. Code Details

      How the Code Works:

        E.1. WebDriver Setup:
               E.1.1. The script begins by setting up the ChromeDriver WebDriver, which is responsible for automating Google Chrome.
               E.1.2. The path to the chromedriver executable is set using System.setProperty().

        E.2. Navigate to the Webpage:
               E.2.1. The script uses driver.get() to navigate to a webpage containing dynamically loaded elements. In this case, the example URL is https://the-internet.herokuapp.com/dynamic_loading/1.

        E.3. Locating Elements:
               E.3.1. The script locates elements on the page using driver.findElement(By.id()). It locates the Start button (id="start") and interacts with it.
               E.3.2. A WebDriverWait is initialized to allow waiting for dynamic content to load, specifically the element with id="finish".

        E.4. Explicit Wait:
               E.4.1. Explicit Wait is used to pause the execution until the element with the dynamic content (in this case, the text inside the id="finish" element) becomes visible. This is handled by wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).

        E.5. Action and Output:
               E.5.1. Once the dynamic element becomes visible, the script retrieves the text content of the element using dynamicText.getText() and prints it to the console.

        E.6. Error Handling:
               E.6.1. Basic exception handling is implemented using a try-catch block to catch and log any issues that may occur during the execution of the script.

        E.7. Clean Exit:
               E.7.1. The WebDriver session is terminated in the finally block using driver.quit(), ensuring that the browser closes after the execution of the script, regardless of whether it completes successfully or an error occurs.

F. Code Example:

    public class DynamicElements {
       public static void main(String[] args) 
       {
        // Set the path to chromedriver (Update the path as per your system)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the target webpage
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            // Initialize explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Locate and click the start button
            WebElement startButton = driver.findElement(By.id("start")).findElement(By.tagName("button"));
            startButton.click();

            // Wait for the dynamically loaded element to be visible
            WebElement dynamicText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

            // Print the dynamically loaded text
            System.out.println("Dynamic Text: " + dynamicText.getText());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure the browser closes properly
            driver.quit();
        }
      }
    }
    
G. Project Description

    G.1. What It Does:
         G.1.1. Opens a webpage with dynamic content.
         G.1.2. Waits for a button to be clicked (Start button).
         G.1.3. Once the button is clicked, the page dynamically loads content.
         G.1.4. After the content is loaded, the script prints the loaded text.

    G.2. Why This Script:
         This project highlights how to handle dynamic elements in Selenium. It uses explicit waits to ensure the elements are loaded before interacting with them, making the automation script more reliable.

H. Future Enhancements

    H.1. Add more complex dynamic scenarios with multiple elements.
    H.2. Implement different wait strategies, such as fluent wait.
    H.3. Add error handling and logging mechanisms for better diagnostics.
