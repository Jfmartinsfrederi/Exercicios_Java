package costs;

import dto.PeriodCostDto;

import java.util.List;

public interface PeriodCostDao {
    List<PeriodCostDto> findAll();
}
