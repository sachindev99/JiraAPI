# **Jira API Automation with Rest Assured**

Jira, developed by Atlassian, is a comprehensive Issue and Project Management Software utilized by teams worldwide. This repository focuses on automating interactions with the Jira REST API using the Rest Assured Java library.

**Introduction**

The Jira REST API empowers developers to interact with Jira programmatically, facilitating the creation of applications, scripting interactions, and integrating with other systems.

**Documentation**

For detailed documentation of the Jira API, please refer to the official Jira API Documentation.

**Features**

Basic Authentication: Implement Basic Auth and Cookie-based authentication for authenticating API requests.
Request and Response Spec Builders: Utilize RequestSpecBuilder and ResponseSpecBuilder to pass and assert common values across all API requests.
Serialization: Implement serialization techniques for constructing API Request Payloads using Plain Old Java Object (POJO) classes.

**Setup & Usage**

To begin using the automated API endpoints, follow the following installation instructions:

Step 1: Install Jira Software Server on your local machine. It's available for a 30-day free trial period.

Step 2: Launch the Jira Server.

Step 3: Create a project and take note of the project key (this will be used in API requests).

Step 4: Clone or download this repository.

Step 5: Import the repository as a Maven project in Eclipse IDE.

Step 6: Open the pom.xml file. If necessary, modify it according to your requirements.

Step 7: Navigate to Project > Maven > Update Project.

Step 8: Open the config.properties file located under src/main/java > com.jira.config package.

Step 9: Provide your API base URI, Jira username and password, and any other required details. Save the changes.

Step 10: Execute the test cases using the testng.xml file found under src/test/resources > TestRunner or via Maven commands.

**Contributing**

Contributions to this project are welcome! If you have suggestions for improvements, bug reports, or would like to add new features, please feel free to open an issue or submit a pull request.

