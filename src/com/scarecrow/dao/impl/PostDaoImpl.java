package com.scarecrow.dao.impl;

import java.util.List;

import com.scarecrow.bean.Post;
import com.scarecrow.dao.PostDao;
@SuppressWarnings("unchecked")
public class PostDaoImpl extends BaseDaoImpl<Post> implements PostDao {
	
	//查询每个分类下的前十个最新发表的帖子
	@Override
	public List<Post> queryEachCategoryPostTopTen() {
		//mysql :SELECT p.* FROM post p WHERE 10> (SELECT COUNT(*) FROM post WHERE category_id = p.category_id AND post_id > p.post_id ) order by p.id desc
		String hql = "SELECT p FROM Post p WHERE 10> (SELECT COUNT(p1) FROM Post p1 WHERE p1.category.id = p.category.id AND p1.id > p.id ) order by p.id desc";
		return getSession().createQuery(hql).list();
	}
	
	//查询某个分类的帖子总数量
	@Override
	public int getRowCount(String categoryId) {
		String hql = "select count(p) from Post p where p.category.id=:categoryId";
		Number number = (Number)getSession().createQuery(hql).setString("categoryId", categoryId).uniqueResult();
		return number.intValue();
	}
	
	//查询当前页的记录信息
	@Override
	public List<Post> queryPostByPage(String categoryId, int pageStart, int pageSize) {
		String hql = "From Post p where p.category.id=:categoryId order by id desc";
		return getSession().createQuery(hql).setString("categoryId", categoryId).setFirstResult(pageStart).setMaxResults(pageSize).list();
	}
	
	//通过用户id查询帖子列表记录总数
	@Override
	public int getPostCountByUserId(String userId) {
		String hql = "select count(p) from Post p where p.user.id=:userId";
		Number number = (Number)getSession().createQuery(hql).setString("userId", userId).uniqueResult();
		return number.intValue();
	}
	
	//通过用户id查询帖子列表
	@Override
	public List<Post> queryPostByUserId(String userId, int startRows, int rows) {
		String hql = "From Post p  LEFT JOIN FETCH p.user LEFT JOIN FETCH p.category c  where p.user.id=:userId order by p.id desc";
		return getSession().createQuery(hql).setString("userId", userId).setFirstResult(startRows).setMaxResults(rows).list();
	}
	
	//更新帖子类别信息
	@Override
	public void updatePostCategory(Post post) {
		String hql= "update Post p set p.category = :category where id=:id";
		getSession().createQuery(hql).setParameter("category", post.getCategory()).setInteger("id", post.getId()).executeUpdate();
	}

	//更新帖子浏览量
	@Override
	public void updatePostViews(Post post) {
		String hql= "update Post set postViews = :postViews where id=:id";
		getSession().createQuery(hql).setInteger("postViews", post.getPostViews()).setInteger("id", post.getId()).executeUpdate();
	}
	
	//根据帖子id查询帖子信息
	@Override
	public Post getPostByPostId(Integer id) {
		String hql = "From Post p LEFT JOIN FETCH p.user where p.id=:id";
		return (Post) getSession().createQuery(hql).setInteger("id", id).uniqueResult();
	}
	
	//后台查询当前页信息
	@Override
	public List<Post> queryPostPageList(String type,String key ,int startRows, int _rows, String sort,
			String order) {
		String hql = "From Post p LEFT JOIN FETCH p.category LEFT JOIN FETCH p.user WHERE p."+type+" like :key order by p."+sort+" "+order;
		return getSession().createQuery(hql).setString("key", "%"+key+"%").setFirstResult(startRows).setMaxResults(_rows).list();
	}
}
