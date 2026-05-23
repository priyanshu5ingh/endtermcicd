🛠 Step 1: Create a Maven Project
Open your IDE (IntelliJ, Eclipse, or VS Code).

Create a new Maven project:

GroupId: com.example

ArtifactId: calculator

Version: 1.0-SNAPSHOT

This generates a pom.xml file.

📄 Step 2: Write the Calculator Class
Create a file Calculator.java under src/main/java/com/example/.

java
package com.example;

public class Calculator {

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}
🧪 Step 3: Add JUnit Dependency in pom.xml
Inside <dependencies>:

xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
🧾 Step 4: Write JUnit Test Cases
Create CalculatorTest.java under src/test/java/com/example/.

java
package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calc.addition(6, 4));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calc.subtraction(6, 4));
    }

    @Test
    public void testMultiplication() {
        assertEquals(24, calc.multiplication(6, 4));
    }

    @Test
    public void testDivision() {
        assertEquals(1.5, calc.division(3, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        calc.division(5, 0);
    }
}
▶️ Step 5: Run Tests with Maven
Open terminal in project root and run:

bash
mvn clean test
You should see all tests passing.

⚙️ Step 6: Integrate with Jenkins
Install Jenkins locally or on a server.

Install Maven Integration plugin in Jenkins.

Create a new Jenkins job:

Type: Maven project

Source Code Management: Connect to your GitHub repo (if using Git).

Build: Add goal clean test.

Save and build the project.

📊 Step 7: Show Build Status
Jenkins will run your Maven tests.

If successful, you’ll see a blue/green build status.

If tests fail, Jenkins will mark the build as red.

You can also:

Add a Jenkins badge to your GitHub README:

markdown
![Build Status](http://your-jenkins-server/job/calculator/badge/icon)
✅ At this point:

You have a Java Calculator class.

JUnit tests are running via Maven.

Jenkins is integrated and showing build status.

Would you like me to also show you how to push this project to GitHub and connect Jenkins with GitHub webhooks, so every commit automatically triggers a build?

give complete pom
Here’s a complete pom.xml you can use for your Calculator project. It includes the Maven project setup, JUnit dependency, and build plugins that work well with Jenkins.

xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>calculator</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>Calculator</name>
    <description>Simple Calculator project with JUnit tests</description>

    <properties>
        <!-- Java version -->
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>4.13.2</junit.version>
    </properties>

    <dependencies>
        <!-- JUnit for testing -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- Compiler plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>${maven.compiler.source}</source>
                    <target>${maven.compiler.target}</target>
                </configuration>
            </plugin>

            <!-- Surefire plugin for running unit tests -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M7</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                    </includes>
                </configuration>
            </plugin>

            <!-- Jar plugin (optional, for packaging) -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <version>3.2.0</version>
                <configuration>
                    <archive>
                        <manifest>
                            <addClasspath>true</addClasspath>
                            <mainClass>com.example.Calculator</mainClass>
                        </manifest>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
🔑 Key Points:
JUnit dependency ensures your test cases run.

Surefire plugin is what Maven uses to execute tests (mvn test).

Compiler plugin sets Java version compatibility.

Jar plugin is optional but useful if you want to package and run the project.

🚀 Next Steps:
Save this pom.xml in your project root.

Run:

bash
mvn clean test
to verify everything works.

Push the project to GitHub.

In Jenkins:

Create a Maven job.

Configure SCM to pull from GitHub.

Set build goals: clean test.

Run the job → Jenkins will show build status.
