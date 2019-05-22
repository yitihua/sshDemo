package cn.edu.nenu.repository;

import cn.edu.nenu.config.orm.PlatformRepository;
import cn.edu.nenu.domain.Dict;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictRepository extends PlatformRepository<Dict,Long> {
    @Query("from Dict d where d.type=?1 order by d.sort asc")
    List<Dict> findByTypeOrderBySort(String type);
    @Query("from Dict d order by d.sort asc")
    Dict FindFirstByOrderBySortDesc();


}
