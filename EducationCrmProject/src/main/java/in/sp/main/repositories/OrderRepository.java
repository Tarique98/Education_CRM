package in.sp.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.sp.main.entities.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> 
{
	
}
