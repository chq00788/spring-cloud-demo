package com.chq.project.cloud.order.common.exception;
import com.chq.project.cloud.common.entity.Response;
import com.chq.project.cloud.common.enums.ResponseEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 统一异常处理
 * @author CHQ
 */
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 404
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public Response noHandlerFoundHandler(Exception e) {
        e.printStackTrace();
        return Response.fail(ResponseEnum.NOT_FOUND);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response handler(Exception e) {
        e.printStackTrace();
        return Response.fail(ResponseEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response RuntimeException(Exception e) {
        e.printStackTrace();
        return Response.fail(e.getMessage());
    }

}