package jpabook.jpashop.domain.item;

/**
 * Created by wansoo.
 * User: accomplishlee
 */
public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException() {
        super();
    }

    public NotEnoughStockException(String message) {
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
