# magnolia-module-logininfo
Simple module to display useful information on Magnolia Admincentral login screen

---
This module allows to display few information on a Magnolia CMS Login screen, useful to let editorial and admin team to understand on which environment.

## Installation

The quicker way to try this module is to download the .jar from releases and drop it in WEB-INF/lib folder of your Magnolia instance.

For a "pro" and indeed better usage, clone from this repo, declare it in your webapp pom using the following Maven dependency: 

```xml
<!-- Magnolia Module LoginInfo -->
<dependency>
    <groupId>com.tinext.magnolia</groupId>
    <artifactId>magnolia-module-logininfo</artifactId>
    <version>1.0.0</version>
</dependency>
```

If everything works fine, you should see the following standard information at Magnolia startup: 

![Magnolia Module Logininfo - Installation 1](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-001.png)

Just install it. No additional information are required.
When installation ends, your login screen should appear with a new *header bar*: 

![Magnolia Module Logininfo - Installation 2](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-002.png)

This module has been succesfully tested against Magnolia CE / EE 5.4.x

## Configuration

What this module does in the background?
During installation, it replace the standard "form" securityCallback: 

![Magnolia Module Logininfo - Installation 2](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-004.png)

with a dedicated class, able to expose a new **infofn** Freemarker utility, and a dedicated HTML file. This file, a Freemarker file to be more precise, is taken from the Community Edition of the current Magnolia installation, adding a simple header bar on top.

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

You can put static text, like this: 

![Magnolia Module Logininfo - Static text](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-008.png)

Or you can show a lot of properties, mixed with text: 

![Magnolia Module Logininfo - Props and text](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-010.png)

Or you can send useful messages to editors: 

![Magnolia Module Logininfo - Message to editors](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-009.png)

If needed, you can disable it removing the lines from Magnolia Module Logininfo cofiguration: 

## Fallback or module removal

After module wrong installation or customization, or module removal, you can encounter a screen like the following one: 

![Magnolia Module Logininfo - SecurityCallback error](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-005.png)

In this case, you can use a different login method to bypass the "form" one: just put the following queryString:

** ?mgnlUserId=<username>&mgnlUserPSWD=<password> **

![Magnolia Module Logininfo - Alternative login method](https://raw.githubusercontent.com/matteopelucco/magnolia-module-logininfo/master/screenshot-007.png)

In this way you can tune your Magnolia instance to use the standard configuration for "form" callback: 

```
class: info.magnolia.cms.security.auth.callback.FormClientCallback
loginForm: /defaultMagnoliaLoginForm/login.html
```

## License

Feel free to use this module as you want. But if you use it and you like it, let me know!