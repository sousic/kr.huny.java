package kr.huny.controller;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.utils.UploadFileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016-10-12.
 */
@Controller
@RequestMapping(value = "/attach")
public class FileUploadController extends baseController {



    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    public @ResponseBody
    Map<String, Object> upload(long bm_seq, long b_seq, MultipartFile uploadFile)
    {
        resultJson = new HashMap<String, Object>();
        resultJson.put("resultCode", 1);
        resultJson.put("resultMsg", "성공");

        String savedPath = null;
        try {
            savedPath = UploadFileHelper.uploadFile(propertyHelper.getUploadPath(), uploadFile.getOriginalFilename(), uploadFile.getBytes());



        } catch (Exception ex) {
            new LogException(ex).printStackTrace();
        }

        resultJson.put("url", savedPath);

        return resultJson;
    }
}
