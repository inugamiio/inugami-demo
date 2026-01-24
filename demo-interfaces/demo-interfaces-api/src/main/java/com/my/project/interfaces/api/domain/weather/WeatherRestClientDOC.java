package  com.my.project.interfaces.api.domain.weather;

import  io.inugami.framework.interfaces.rest.*;
import  io.swagger.v3.oas.annotations.media.*;
import  io.swagger.v3.oas.annotations.responses.*;
import  java.lang.annotation.*;
import  lombok.experimental.UtilityClass;


@UtilityClass
public class WeatherRestClientDOC  {
     @PotentialErrors({
          @PotentialError(errorCode="WEATHER-2_0", httpStatus=400, type="functional", domain="WEATHER", errorMessage="city required", errorMessageDetail="city required"),
          @PotentialError(errorCode="WEATHER-2_1", httpStatus=400, type="functional", domain="WEATHER", errorMessage="unknown city", errorMessageDetail="unknown city"),
          @PotentialError(errorCode="WEATHER-2_2", httpStatus=404, type="functional", domain="WEATHER", errorMessage="weather not found", errorMessageDetail="weather not found")
     })
     @ApiResponses({
         @ApiResponse(
         	responseCode="200",
         	description="Successful operation",
         	content={
                      @Content(
                      	mediaType="application/json",
                      	examples={                 
                                       @ExampleObject(
                                       	name="Nominal",
                                       	value="""
                                                {
                                                  "code" : "OVERCAST",
                                                  "elevation" : 387.0,
                                                  "icon" : "cloudy-dense",
                                                  "label" : "cloudy-dense",
                                                  "latitude" : 46.28,
                                                  "longitude" : 6.1599994,
                                                  "temperature" : 2.1,
                                                  "time" : "2023-06-01T12:00:00",
                                                  "weathercode" : 3,
                                                  "windspeed" : 8.6
                                                }
                                       """
                                       )
                      
                      	}
                      )
         		}
         	)
         ,
         @ApiResponse(
         	responseCode="400",
         	description="Functional error on executing operation",
         	content={
                      @Content(
                      	mediaType="application/json",
                      	examples={                 
                                       @ExampleObject(
                                       	name="Error codes",
                                       	value="""
                                                [
                                                "WEATHER-2_0  |  functional  |  WEATHER     |  city required",
                                                "WEATHER-2_1  |  functional  |  WEATHER     |  unknown city"
                                                ]
                                       """
                                       ),
                                       @ExampleObject(
                                       	name="Response with error code",
                                       	value="""
                                                {
                                                  "details" : {
                                                    "errorCode" : {
                                                      "statusCode" : 400,
                                                      "domain" : "WEATHER",
                                                      "errorCode" : "WEATHER-2_0",
                                                      "errorType" : "functional",
                                                      "message" : "city required",
                                                      "exploitationError" : false,
                                                      "rollbackRequire" : false,
                                                      "retryable" : false
                                                    }
                                                  },
                                                  "errors" : [ ],
                                                  "parameters" : [ ],
                                                  "status" : 400
                                                }
                                       """
                                       )
                      
                      	}
                      )
         		}
         	)
         ,
         @ApiResponse(
         	responseCode="404",
         	description="Functional error on executing operation",
         	content={
                      @Content(
                      	mediaType="application/json",
                      	examples={                 
                                       @ExampleObject(
                                       	name="Error codes",
                                       	value="""
                                                [
                                                "WEATHER-2_2  |  functional  |  WEATHER     |  weather not found"
                                                ]
                                       """
                                       ),
                                       @ExampleObject(
                                       	name="Response with error code",
                                       	value="""
                                                {
                                                  "details" : {
                                                    "errorCode" : {
                                                      "statusCode" : 404,
                                                      "domain" : "WEATHER",
                                                      "errorCode" : "WEATHER-2_2",
                                                      "errorType" : "functional",
                                                      "message" : "weather not found",
                                                      "exploitationError" : false,
                                                      "rollbackRequire" : false,
                                                      "retryable" : false
                                                    }
                                                  },
                                                  "errors" : [ ],
                                                  "parameters" : [ ],
                                                  "status" : 404
                                                }
                                       """
                                       )
                      
                      	}
                      )
         		}
         	)
     })
     @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
     @Retention(RetentionPolicy.RUNTIME)
     @Inherited
     public @interface DocGetByCity  {}


}