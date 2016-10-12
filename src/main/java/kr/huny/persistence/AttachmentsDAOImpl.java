package kr.huny.persistence;

import kr.huny.domain.board.AttachmentsVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by sousic on 2016-10-12.
 */
@Repository
public class AttachmentsDAOImpl implements AttachmentsDAO {

    @Inject
    private SqlSession sqlSession;

    private final String namespace = "kr.huny.persistence.AttachmentsDAO";

    @Override
    public void insertAttachments(AttachmentsVO attachmentsVO) throws Exception {
        sqlSession.insert(namespace + ".insertAttachments", attachmentsVO);
    }

    @Override
    public AttachmentsVO readAttachments(AttachmentsVO attachmentsVO) throws Exception {
        return sqlSession.selectOne(namespace + ".readAttachments", attachmentsVO);
    }

    @Override
    public void updateAttachments(AttachmentsVO attachmentsVO) throws Exception {
        sqlSession.update(namespace + ".updateAttachments");
    }

    @Override
    public List<AttachmentsVO> selectAttachemtnsList(AttachmentsVO attachmentsVO) throws Exception {
        return sqlSession.selectList(namespace + ".selectAttachemtnsList", attachmentsVO);
    }

    @Override
    public void deleteAttachments(AttachmentsVO attachmentsVO) throws Exception {
        sqlSession.delete(namespace + ".deleteAttachments", attachmentsVO);
    }
}
