# magnolia-module-logininfo
Simple module to display useful information on Magnolia Admincentral login screen

---
This module allows to display few information on a Magnolia CMS Login screen, useful to let editorial and admin team to understand on which environment.

## Installation

The quicker way to try this module is to download the .jar in the bundle and drop it in WEB-INF/lib folder of your Magnolia instance.
For a "pro" and indeed better usage, clone from this repo, declare it in your webapp pom using the following Maven dependancy: 

```xml
<!-- Magnolia Module LoginInfo -->
<dependency>
    <groupId>com.tinext.magnolia</groupId>
    <artifactId>magnolia-module-logininfo</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

If everything works fine, you should see the following standard information at Magnolia startup: 

![Magnolia Module Logininfo - Installation 1](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-001.png)

Just install it. No additional information are required.
When installation ends, your login screen should appear with a new *header bar*: 

![Magnolia Module Logininfo - Installation 2](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-002.png)

This module has been succesfully tested against Magnolia CE / EE 5.4.x

## Configuration

[put here a sample of config (callback + module config)]

## What you can do

The simplest usage is to enter 2 lines: 
- heading
- subheading

But if you want to display instance-specific information, you can use Magnolia Properties, with the following syntax: 

```
props['propname']
```

By default, module installs with this approach for the second line: 

![Magnolia Module Logininfo - First Login](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-003.png)

Feel free to change it, or to use as many properties you need (full properties list is available in "About Magnolia" config app)

## Examples


