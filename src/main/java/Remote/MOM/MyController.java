package Remote.MOM;



public class MyController implements common.Controller {

    private Model model;

    public MyController(Model m){
        this.model = m;

        new Thread(() -> {
            try {
                RabbitMQUtil.setup();
                RabbitMQUtil.consumeMessages((consumerTag, delivery) -> {
                    String message = new String(delivery.getBody(), "UTF-8");
                    if ("increment".equals(message)) {
                        increment();
                        try {
                            RabbitMQUtil.sendMessage("state:" + model.getState());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void increment(){
        model.incrementState();
    }
}
