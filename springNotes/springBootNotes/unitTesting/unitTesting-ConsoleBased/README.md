# Spring Boot Unit Testing Demo

## Project Overview

This project demonstrates unit testing in a Spring Boot application using JUnit 5. It implements a simple calculator service with basic arithmetic operations and comprehensive test coverage.

### Project Structure
```
src/
├── main/java/com/example/unittest/
│   ├── UnitTestDemoApplication.java
│   └── service/
│       └── CalculatorService.java
└── test/java/com/example/unittest/
    └── service/
        └── CalculatorServiceTest.java
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Building and Running the Application

1. Clone the repository:
```bash
git clone <repository-url>
cd spring-boot-unittest-demo
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

### Expected Console Output
```
Calculator Demo Results:
Addition: 5 + 3 = 8
Subtraction: 10 - 4 = 6
Multiplication: 6 * 7 = 42
Division: 20 / 5 = 4
```

## Running Tests

Execute the test suite using Maven:
```bash
mvn test
```

Or run specific test classes in your IDE by right-clicking on the test file and selecting "Run Test".

## Test Scenarios

The test suite (`CalculatorServiceTest.java`) covers the following scenarios:

### Basic Operations
- Addition of positive numbers
- Addition with negative numbers
- Subtraction of positive numbers
- Subtraction with negative numbers
- Multiplication of positive numbers
- Multiplication with negative numbers
- Division of positive numbers
- Division with negative numbers

### Edge Cases and Error Handling
- Division by zero (throws ArithmeticException)
- Operations with null inputs (throws IllegalArgumentException)
- Operations with maximum and minimum integer values

### Sample Test Output
```
[INFO] Running com.example.unittest.service.CalculatorServiceTest
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
```

## Test Output Details

### Successful Test Cases
```
√ Addition of positive numbers (2 + 3 = 5)
√ Addition with negative numbers (-2 + 3 = 1)
√ Subtraction of positive numbers (5 - 3 = 2)
√ Multiplication test (4 * 5 = 20)
√ Division test (10 / 2 = 5)
```

### Exception Test Cases
```
√ Division by zero throws ArithmeticException
√ Null input throws IllegalArgumentException
```

## Contributing

Feel free to submit issues and enhancement requests or create pull requests with improvements.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## UI Libraries Setup

The project uses several UI libraries that can be served either locally or via CDN.

### Available Libraries
- Bootstrap 5.3.2 (CSS and JS)
- Bootstrap Icons 1.11.2
- Highlight.js 11.9.0

### Directory Structure
```
lib/
├── css/
│   ├── bootstrap.min.css
│   ├── bootstrap-icons.css
│   └── highlight.min.css
├── js/
│   ├── bootstrap.bundle.min.js
│   └── highlight.min.js
└── fonts/
    └── bootstrap-icons.*
```

### Downloading Libraries Locally

1. Execute the download script:
```bash
chmod +x download-ui-libs.sh
./download-ui-libs.sh
```

Expected output:
```
Creating directory structure...
Downloading Bootstrap CSS...
Downloading Bootstrap JS...
Downloading Bootstrap Icons CSS...
Downloading Bootstrap Icons Fonts...
Downloading Highlight.js CSS...
Downloading Highlight.js JS...
All libraries downloaded successfully!
```

### Switching Between Local and CDN

The application uses a configuration flag `USE_LOCAL_LIBS` in `config.js`:

```javascript
const config = {
    useLocalLibs: true  // Set to false to use CDN versions
};
```

To switch to CDN versions:
1. Open `config.js`
2. Set `useLocalLibs` to `false`
3. Refresh the page
3. Refresh the page

All library paths will automatically update based on this setting.

### Configuration System (config.js)

The `config.js` file manages library paths and provides a flexible configuration system for the application's UI resources.

#### Overview
The configuration system allows switching between local and CDN-hosted libraries through a simple boolean flag. It handles path resolution automatically and provides a consistent API for accessing library resources.

#### Configuration Options

```javascript
const config = {
    useLocalLibs: true,          // Toggle between local and CDN resources
    version: {
        bootstrap: '5.3.2',      // Bootstrap version
        bootstrapIcons: '1.11.2', // Bootstrap Icons version
        highlightjs: '11.9.0'    // Highlight.js version
    },
    paths: {
        local: {
            css: '/lib/css/',    // Local CSS directory
            js: '/lib/js/',      // Local JavaScript directory
            fonts: '/lib/fonts/' // Local fonts directory
        },
        cdn: {
            bootstrap: 'https://cdn.jsdelivr.net/npm/bootstrap@{version}',
            bootstrapIcons: 'https://cdn.jsdelivr.net/npm/bootstrap-icons@{version}',
            highlightjs: 'https://cdnjs.cloudflare.com/ajax/libs/highlight.js/{version}'
        }
    }
};
```

#### Usage Examples

1. Getting a library path:
```javascript
// Get Bootstrap CSS path
const bootstrapCss = config.getPath('bootstrap', 'css');

// Get Highlight.js JavaScript path
const highlightJs = config.getPath('highlightjs', 'js');
```

2. Checking configuration:
```javascript
// Check if using local libraries
if (config.useLocalLibs) {
    console.log('Using local libraries');
}

// Get current Bootstrap version
const version = config.version.bootstrap;
```

#### Path Resolution System

The path resolution system follows these rules:

1. For local resources:
- CSS files: `lib/css/{filename}.css`
- JavaScript files: `lib/js/{filename}.js`
- Fonts: `lib/fonts/{filename}`

2. For CDN resources:
- Replaces {version} placeholder with the corresponding version
- Constructs full URLs based on CDN templates
- Automatically appends appropriate file extensions

#### API Documentation

```javascript
config.getPath(library, type)
// Parameters:
// - library: 'bootstrap'|'bootstrapIcons'|'highlightjs'
// - type: 'css'|'js'|'fonts'
// Returns: string (resolved path)

config.getVersion(library)
// Parameters:
// - library: 'bootstrap'|'bootstrapIcons'|'highlightjs'
// Returns: string (version number)

config.isLocal()
// Returns: boolean (true if using local libraries)
```

#### Implementation Examples

1. Loading CSS in HTML:
```html
<link rel="stylesheet" href="/lib/css/bootstrap.min.css">
```

2. Dynamic path resolution in JavaScript:
```javascript
function loadLibrary(library, type) {
    const path = config.getPath(library, type);
    const element = type === 'css' 
        ? createLinkElement(path)
        : createScriptElement(path);
    document.head.appendChild(element);
}
```

3. Version checking:
```javascript
function isCompatible(library, minVersion) {
    const currentVersion = config.getVersion(library);
    return compareVersions(currentVersion, minVersion) >= 0;
}
```
