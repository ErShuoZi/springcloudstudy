package springcloud.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CoustonUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) { //资源清洗
        //isBlank:判断该值不等于null,并且有长度,而且不是全部为空格
        if (StringUtils.isBlank(originUrl)) {
            return originUrl;
        }
        if (originUrl.startsWith("/member/getMemberById")) {
            //如果得到的url是以/member/getMemberById开头,则进行处理,统一返回
            //在Sentinel对/member/getMemberById 添加流控制即可
            return "/member/getMemberById/*";
        }
        return originUrl;
    }
}
