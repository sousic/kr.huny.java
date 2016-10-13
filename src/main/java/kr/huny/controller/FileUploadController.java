package kr.huny.controller;

import kr.huny.Exceptions.LogException;
import kr.huny.controller.common.baseController;
import kr.huny.domain.board.AttachmentsVO;
import kr.huny.service.AttachmentsService;
import kr.huny.utils.UploadFileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sousic on 2016-10-12.
 */
@Controller
@RequestMapping(value = "/attach")
public class FileUploadController extends baseController {
    @Autowired
    private AttachmentsService attachmentsService;


    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = "application/json;charset=utf8")
    public @ResponseBody
    Map<String, Object> upload(long bm_seq, long b_seq, MultipartFile uploadFile)
    {
        resultJson = new HashMap<String, Object>();
        resultJson.put("resultCode", 1);
        resultJson.put("resultMsg", "성공");

        String attachmentsURL = null;

        AttachmentsVO attachmentsVO = new AttachmentsVO();

        try {
            UploadFileHelper.FileInfo fileInfo = UploadFileHelper.uploadFile(propertyHelper.getUploadPath(), uploadFile.getOriginalFilename(), uploadFile.getBytes());

            attachmentsVO.setFilename(uploadFile.getOriginalFilename());
            attachmentsVO.setFilesize(uploadFile.getSize());
            attachmentsVO.setContentType(uploadFile.getContentType());
            attachmentsVO.setSave_name(fileInfo.getDestFileName());
            attachmentsVO.setSave_path(fileInfo.getDestSavePath().replace("\\","/"));

            attachmentsService.insertAttachments(attachmentsVO);
            logger.info(attachmentsVO.toString());

            attachmentsURL = String.format("/attach/file?seq=%s", attachmentsVO.getSeq());

        } catch (Exception ex) {
            new LogException(ex).printStackTrace();
        }

        resultJson.put("url", attachmentsURL);

        return resultJson;
    }

    @RequestMapping(value = "file", method = RequestMethod.GET)
    public void file(long seq)
    {
        AttachmentsVO attachmentsVO = new AttachmentsVO();
        try {
            attachmentsVO.setSeq(seq);
            attachmentsVO = attachmentsService.selectAttachments(attachmentsVO);

            String path = propertyHelper.getUploadPath() + attachmentsVO.getSave_path().replace("/","\\") + File.separator + attachmentsVO.getSave_name();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();

        }
        catch (Exception ex)
        {
            new LogException(ex).printStackTrace();
        }
    }
}
