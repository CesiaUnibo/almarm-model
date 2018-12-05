# almarm-model
Core model of the University of Bologna international relationship management system AlmaRM

## What is AlmaRM Model

AlmaRM Model is a Java representation of the model on which the [AlmaRM application](https://www.unibo.it/en/services-and-opportunities/online-services/online-services-for-students-1/guide-to-online-student-services/almarm) is built.

No binary distribution is provided, neither for AlmaRM Model nor for the AlmaRM application.

The source code of AlmaRM Model is issued by the University of Bologna as a member of the [Coimbra Group](https://www.coimbra-group.eu/) as part of the [Open Source University Alliance](https://open-source-alliance.erasmuswithoutpaper.eu/).

The source code is distributed as is, under the terms and conditions of the relevant license. 

## How to use AlmaRM Model

AlmaRM Model as such is not a working system and some classes may not even compile, as they may import other classes not released in AlmaRM Model. AlmaRM Model is only the code base on which other international mobility management systems can be developed.

The main use of AlmaRM Model is to understand how at the University of Bologna the entities, involved in the thousands of international mobilities (both incoming and outgoing) managed every year, were modeled.

The AlmaRM application, in its entirety, integrates with other systems implemented at the University of Bologna, in order to track and automate processes related to international mobility, such as, payment of scholarships, integration in the study plan of activities carried out abroad and listed in the learning agreement, creating accounts and e-mail boxes, and so on.

The AlmaRM application also provides mechanisms for communication with partner universities, such as web pages for completing data relating to exchange agreements, sending partners lists of nominations, registration pages for individual incoming students, etc.

The AlmaRM application tracks the mobility process of outgoing students since their application to mobility calls, until their return to Bologna, as well as each relevant intermediate step (e.g., mobility application evaluation, learning agreement approval, grant payment, management of possible mobility extension, etc.). This management is not limited to Erasmus+ programme, but also covers other programmes run by the University of Bologna.

Likewise, the AlmaRM application also tracks the mobility of incoming students, since their nomination until they leave the University of Bologna.

Given the variety of programmes managed, the high number of students who take part in international mobility every year, the handling of many aspects of a mobility process, the organizational complexity of a university as large as the University of Bologna, we think that the model on which the AlmaRM application is built is, in itself, sufficiently interesting for other higher education institutions, since it has been created to cover several use cases that could be shared with other universities.
