package com.laigeoffer.pmhub.base.core.utils;

import com.laigeoffer.pmhub.base.core.core.domain.R;
import com.laigeoffer.pmhub.base.core.exception.ServiceException;

import java.util.Objects;

public class FeignResultUtils {
    public static <T> T getResultByObjectsCheck(R<T> result, String message) {
        if (Objects.isNull(result) || Objects.isNull(result.getData())
                || R.fail().equals(result.getData())) {
            throw new ServiceException(message);
        }
        return result.getData();
    }
    public static <T> T getResultByStringUtilsCheck(R<T> result, String message) {
        if (StringUtils.isNull(result) || StringUtils.isNull(result.getData())
                || R.fail().equals(result.getData())) {
            throw new ServiceException(message);
        }
        return result.getData();
    }
}
