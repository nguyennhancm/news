package tv.utils.valueItem.manager.impl;

import tv.utils.manager.BaseManager;
import tv.utils.valueItem.entities.SequenceValueItem;
import tv.utils.valueItem.manager.ISequenceValue;

import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.persistence.Cacheable;

/**
 * Created with IntelliJ IDEA.
 * User: NGUYEN VAN NHAN
 * Date: 6/4/2015
 * Time: 11:02 AM
 * Long Van Soft Solution JSC
 * To change this template use File | Settings | File Templates.
 */
@Singleton(name = "SequenceValue")
@Local(ISequenceValue.class)
@Cacheable(true)
public class SequenceValue extends BaseManager implements ISequenceValue {

    @Override
    public String getSequenceValueItem(Class forClass) {
        SequenceValueItem generalId = find(SequenceValueItem.class, forClass.getSimpleName());
        if (null == generalId){
            generalId = new SequenceValueItem();
            generalId.setSeqName(forClass.getSimpleName());
            generalId.setSeqId(3009215);
            getEntityManager().merge(generalId);
        }
        int id = generalId.getSeqId();
        generalId.setSeqId(++id);
        getEntityManager().merge(generalId);
        return String.valueOf(id);
    }

    @Override
    public String getClassName() {
        return getClass().getSimpleName();
    }

}
