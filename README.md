# SPRINGBOOT-MICROSERVICE-SPRING-CLOUD
This project contains example of microservices applications with spring boot and spring cloud.


# description for Exception Handling in Spring RESTful Web Service

1. Introduction
We might have been across some of the several ways by which we can handle exceptions in a RESTful web service application in Spring. In this article, we will try to explore the best approach we can take to achieve efficient exception handling.

2. Problem Statement
Let’s create a simple application that will identify the employee name in the REST URI. If the employee name provided in the request is numeric, let our application throw a custom exception, which we will be handling through the Exception Handlers, and accordingly return the JSON response to the client. The success response will be the JSON with employee details, while the failure response will be an error JSON with errorCode and the proper error message.

Note the @ExceptionHandler method in our controller, which should handle only the EmployeeException thrown in any of the layers of our application.

But what if a NullPointerException gets thrown from nowhere. To be on the safer side, we must have a generic exception handler in our application, which handles all other exception types, such as IOException, NullPointerException and so on. To do that, Spring introduced @ControllerAdvice in version 3.2, where can create a Controller Advice class in our application, which would be capable of handling all the global exception scenarios.

A class which annotated with @ControllerAdvice will be registered as the global exception handler.

This means that if we ever get an unexpected exception in our application other than the custom exception, a generic error object will be prepared, with a generic error code and error message, which will be returned as error JSON response.

In Spring version earlier than 3.2, creating with a single base controller, extending all the individual controllers, instead of @ControllerAdvice would be a better alternative.

There is something to note here. Error JSON response is not possible to be returned in Spring 3.0.x with ResponseEntity, because of the lack of support Spring 3.0.x provides. The alternative for this would be to use BeanNameViewResolver with ModelAndView as the return type. We will soon be coming up with an example application on this.
