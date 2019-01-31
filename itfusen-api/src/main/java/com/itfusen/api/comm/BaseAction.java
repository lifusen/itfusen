package com.itfusen.api.comm;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import com.itfusen.domain.comm.BaseEntity;
import com.itfusen.domain.dto.ResponseResult;
import com.itfusen.domain.enums.ResponseEnum;
import com.itfusen.domain.exception.ResponseException;
import com.itfusen.service.comm.BaseService;

/**
 *author lifusen
 *date 2018年10月29日
 *description 基本Action
 */
public abstract class BaseAction <T extends BaseEntity,E extends BaseService<T>>{
    /**
     * public query method
     * @param type
     * @param object
     * @param service
     * @return
     */
    protected ResponseResult query(int type, T object,E service,Logger logger){

    	ResponseResult result = null;
    	List<T> list = new ArrayList<>();
        try {
            switch (type)
            {
                case 1:
                	list = service.queryAll();
                    break;
                case 2:
                    list = service.queryByField(object);
                    break;
            }
            result = new ResponseResult(ResponseEnum.SUCCESS, list);
        } catch(ResponseException e){
            logger.error(e.getMessage(),e);
            result = new ResponseResult(e.getErrorEnum());
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result = new ResponseResult(ResponseEnum.FAILED);
        }
        return result;
    }

    /**
     * public operation method
     * @param type
     * @param object
     * @param service
     * @return
     */
    protected ResponseResult operation(List<T> list, int type,E service,Logger logger){
    	ResponseResult result = null;
        try {
            switch (type)
            {
            case 1:
                if(list !=null && list.size() ==1)
                service.insert((T)list.get(0));
                break;
            case 2:
                if(list !=null && list.size() ==1)
                service.update((T)list.get(0));
                break;
            case 3:
                if(list !=null && list.size() ==1)
                service.delete(list.get(0).getId());
                break;
            }
            result = new ResponseResult(ResponseEnum.SUCCESS, list);
        } catch(ResponseException e)
        {
            logger.error(e.getMessage(),e);
            result = new ResponseResult(ResponseEnum.FAILED);
        } catch (Exception e) 
        {
            logger.error(e.getMessage(),e);
            result = new ResponseResult(ResponseEnum.FAILED);
        }
        return result;
    }

}
