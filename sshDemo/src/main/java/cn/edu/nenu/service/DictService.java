package cn.edu.nenu.service;

import cn.edu.nenu.domain.Dict;
import cn.edu.nenu.repository.DictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictService {
    @Autowired
    private DictRepository dictRepo;
    public Dict findOne(Long pkId) {
        return dictRepo.findOne(pkId);
    }
    public Dict save(Dict entity){
        return dictRepo.save(entity);
    }

    public Iterable<Dict> save(Iterable<Dict> entities){return dictRepo.save(entities);}
    public void remove(Long pkId){
        dictRepo.delete(pkId);
    }
    public float getMaxSort(){
        return dictRepo.count();
    }
    public List<Dict> findAll(){
        return (List<Dict>) dictRepo.findAll();
    }


}
