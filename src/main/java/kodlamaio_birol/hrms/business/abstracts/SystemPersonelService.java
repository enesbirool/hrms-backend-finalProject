package kodlamaio_birol.hrms.business.abstracts;

import kodlamaio_birol.hrms.core.utilities.results.DataResult;
import kodlamaio_birol.hrms.core.utilities.results.Result;
import kodlamaio_birol.hrms.entities.concretes.SystemPersonel;

import java.util.List;

public interface SystemPersonelService {
    DataResult<List<SystemPersonel>> getSystemPersonels();

    Result addSystemPersonel(SystemPersonel systemPersonel);

    DataResult<SystemPersonel> getSystemPersonelById(int systemPersonelId);

    Result deleteSystemPersonelById(int systemPersonelId);
}
