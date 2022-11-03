package az.online.shop.integration.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import az.online.shop.annotations.IT;
import az.online.shop.dto.OrderReadDto;
import az.online.shop.entity.Order;
import az.online.shop.mapper.OrderReadMapper;
import az.online.shop.util.TestDataImporter;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
class OrderReadMapperTest {

    private final OrderReadMapper orderReadMapper;

    @Test
    void mapEntityToDto() {
        Order expectedResult = TestDataImporter.getClevelandOrders().get(0);
        OrderReadDto actualResult = orderReadMapper.mapFrom(expectedResult);

        assertThat(actualResult.closingDate()).isEqualTo(expectedResult.getClosingDate());
        assertThat(actualResult.registrationDate()).isEqualTo(expectedResult.getRegistrationDate());
    }

    @Test
    void mapEntitiesToDtos() {
        List<Order> expectedResults = TestDataImporter.getIsobelleOrders();
        List<OrderReadDto> actualResults = orderReadMapper.mapFrom(expectedResults);

        for (int i = 0; i < actualResults.size(); i++) {
            assertThat(actualResults.get(i).closingDate()).isEqualTo(expectedResults.get(i).getClosingDate());
            assertThat(actualResults.get(i).registrationDate()).isEqualTo(expectedResults.get(i).getRegistrationDate());

        }
    }
}