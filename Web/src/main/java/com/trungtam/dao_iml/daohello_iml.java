package com.trungtam.dao_iml;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trungtam.dao.daohello;
import com.trungtam.modelEntity.User;

@Repository
@Transactional
public class daohello_iml implements daohello {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<User> getAll() {
		String jql = "SELECT u FROM User u";
		return entityManager.createQuery(jql, User.class).getResultList();
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);

	}

	@Override
	public void detele(User user) {
		// TODO Auto-generated method stub
		entityManager.remove(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		entityManager.merge(user);
	}

	@Override
	public User getID(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(User.class, id);
	}

	@Override
	public User getUserByUserName(String ten) {
		String jql="SELECT u FROM User u WHERE u.ten = ?";
		return entityManager.createQuery(jql, User.class).setParameter(1, ten).getSingleResult();
	}

	// @Autowired
	// JdbcTemplate jdbctemplate;
	//
	// @Override
	// public List<UserDTO> getAll() {
	// String sql="SELECT * FROM hello2.user;";
	//
	// return jdbctemplate.query(sql, new RowMapper<UserDTO>() {
	//
	// @Override
	// public UserDTO mapRow(ResultSet arg0, int arg1) throws SQLException {
	// UserDTO hello2=new UserDTO();
	//
	// hello2.setId(arg0.getInt(1));
	// hello2.setTen(arg0.getString(2));
	// hello2.setTuoi(arg0.getString(3));
	// return hello2;
	// }
	//
	// });
	// }
	//
	// @Override
	// public void add(UserDTO hello2) {
	// String sql="INSERT INTO user values(?,?,?)";
	// jdbctemplate.update(sql,hello2.getId(),hello2.getTen(),hello2.getTuoi());
	//
	// }
	//
	// @Override
	// public void detele(int id) {
	// String sql="detele from user where id=?";
	// jdbctemplate.update(sql,id);
	// }
	//
	// @Override
	// public void update(int id,String ten,String tuoi) {
	// String sql="UPDATE user SET ten=?,tuoi=? where id=?";
	// jdbctemplate.update(sql,ten,tuoi,id);
	// }

}
