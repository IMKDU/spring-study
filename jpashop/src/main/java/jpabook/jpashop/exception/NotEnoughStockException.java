package jpabook.jpashop.exception;

/*
 * 상품 stock 예외처리 클래스
 */
public class NotEnoughStockException extends RuntimeException {

    public NotEnoughStockException(){

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
