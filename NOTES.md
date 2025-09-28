## Refactoring
I've made the refactoring without too many problems, both as a direct MVC where is the controller that notifies the view, 
and as an observer pattern where the model notifies the view.

I was wondering in both cases if it's more correct that the notification to the view already contains the value, 
or it is better that the view asks the model for the value when notified. 
The latter forces the view to have a reference to the model. 

## Extensions
It was easy to add new outputs, like a GUI, or new inputs, like stdin. 
The MVC structure remained the same, either adding a list of views to the controller, 
or using the observer list in the model.

It was also easy to add an active controller that periodically increments the counter.
I've just added a thread in the controller that sleeps and then calls its increment,
and then the main thread of the controller notifies the view.

## Remote
In the distributed versions I am not sure I have preserved correctly the MVC pattern.

With RMI, I had the same structure of interactions between model, controller and view, 
I've just added the remote interfaces for each one. The controller and the model are both managed by the server, 
the view instead is the client.
I have a strange bug where the prints of the view where displayed on the controller's terminal,
I am not sure that it is correct, because the method returns void so it should not return anything to the controller.

With RabbitMQ, I had more problems. I've built a queue for "increment" messages and "state" messages. 
When the user press the button, the view sends an "increment" message which is read by the controller which acts on the model .
Then the controller sends a "state" message with the new value to the view.
I've considered that the controller and the model to be on the same machine.