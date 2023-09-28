# Spring-Email-Client
This is a simple Java Spring Boot application for sending emails with attachments and links using the JavaMailSender. It is designed to be a basic example of how to integrate email functionality into a Spring Boot application.

Getting Started
These instructions will help you set up and run the project on your local machine.

Prerequisites
To run this project, you will need:

Java 8 or higher installed on your machine
Spring Boot framework
A Gmail account (or other SMTP server details if you modify the configuration)
Configuration
You need to configure your email account credentials for this application. Open the application.properties file located in the src/main/resources directory and set the following properties:

properties
Copy code
spring.mail.username=your-email@gmail.com
spring.mail.password=your-email-password
Running the Application
You can run the Spring Boot application by executing the main method in the SpringEmailClientApplication class.

Usage
Once the application is running, it will send emails with attachments and links to the specified recipients. By default, it sends emails to the recipients listed in the triggerMail method of the SpringEmailClientApplication class.

You can modify the recipient list and other email details in the triggerMail method.

Email Service
The email sending functionality is implemented in the EmailSenderService class. It provides methods for sending simple emails and emails with attachments and links.

Dependencies
This project uses the following libraries and dependencies:

Spring Boot
Spring Boot Mail Starter
JavaMailSender
Jakarta Mail
Maven for managing project dependencies
Example
The provided example in the triggerMail method sends emails to the recipients with a sample attachment and a link to an interview video.

java
Copy code
for (String recipient : recipients) {
    service.sendEmailWithAttachmentAndLink(recipient,
            "This is Email Body with Attachment...",
            "This email has attachment",
            "C:\\path\\to\\your\\attachment.jpg",
            interviewLink);
}
License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
This project is a simple demonstration of integrating email functionality into a Spring Boot application.
Feel free to expand and customize it according to your needs.



