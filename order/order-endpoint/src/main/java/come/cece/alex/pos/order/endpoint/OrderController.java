package come.cece.alex.pos.order.endpoint;

import com.cece.alex.order.interfaces.Item;
import com.cece.alex.order.interfaces.OrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderPort orderPort;

    @Autowired
    public OrderController(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping("/order/{orderId}/add")
    public void addItem(@PathVariable int orderId, @RequestBody Item item) {
        orderPort.addItemToOrder(orderId, item);
    }

}
