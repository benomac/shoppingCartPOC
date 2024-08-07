## Technical Assessment

### Shopping Cart

It’s first thing in the morning and you have just sat down at your desk with your morning coffee when you see Barry from the Skunkworks department running over to you, clearly flustered. When he arrives, he explains that he was due to demonstrate a POC to some senior managers, but he forgot to implement a shopping cart microservice and he still hasn’t finished his slide deck. He asks if you can help him throw a service together with the following included.

Instructions on how to run the service
Tests so he can verify any changes he makes to the service and details on how to run the tests
Detail on how to integrate with the service

You agree to help, but explain he hasn’t told you what the service actually needs to do. Barry starts fumbling around his pockets before handing you this scrap of paper.


Shopping Cart POC  
I must be able to specify a list of products that are available to be added to the shopping cart  
I must be able to create a new cart  
I must be able to retrieve the cart  
I must be able to add items to the cart  
I must be able to change the quantity of a specific item in the cart  
I must be able to remove items from the cart  
I must be able to delete a cart  
I must be able to mark a cart for checkout I must be able to signify that a checkout for a cart has been completed  


Barry says it can just be a service on its own with no persistent storage, he just needs something he can integrate with for the purpose of his POC and for it to be hosted in source control that he can access. He says he needs it in two hours so he has time to quickly integrate with it and give his demo, so you are to not spend more than two hours working on it. Barry starts to run back to his desk while shouting “GOOD LUCK” over his sounder. Classic Barry.
Please fill out the following details when you have completed this challenge.



## How To Run
You need to specify a list of items that will be available to add to the cart, this must be done when you run the programme, like so:  
from the sbt shell -  `run apple orange banana`  
from the terminal - `sbt 'run apple orange banana'`  
Here the `apple orange banana` is the arg list that will be used.  
Not providing items will cause the programme to stop, with a message indicating what to do.  

## Tests
Test area available, to run them do:  
from the sbt shell -  `test`  
from the terminal - `sbt 'test'`  
