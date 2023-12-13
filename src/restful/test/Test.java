package restful.test;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import jdk.nashorn.api.tree.Tree;
import net.sf.json.JSONArray;
import restful.bean.Result;
import restful.database.EM;
import restful.entity.Suit;
import restful.entity.Type;
import restful.utils.ImportUtil;
import restful.utils.JSONStringToJSONArray;
import restful.utils.MD5Util;

public class Test {
	public static void main(String[] args) {
		// 测试MD5
		System.out.println(MD5Util.code("hyfhsy"));
		System.out.println(MD5Util.valid("hyfhsy", MD5Util.code("hyfhsy")));

//		 加入测试数据
//		StringBuilder jsonType = new StringBuilder();
//		Scanner in = new Scanner(System.in);
//		while (in.hasNextLine()) {
//			String temp = in.nextLine();
//			jsonType.append(temp);
//			if (temp.equals("]")) {
//				break;
//			}
//		}
		
//		 ------------------测试级联操作和连表查询--------------------
		String HQL_GET_LIST = "select new Map(t1.codeSuit as code, t1.username as username, t2.price as price, t1.zIndex as zIndex, t2.image as image, t2.name as name)"
				+ " from UserSuit t1, Suit t2 where t1.codeSuit = t2.code";
		List<Map<String, String>> result = EM.getEntityManager()
				.createQuery(HQL_GET_LIST)
				.getResultList();
		for (Map<String, String> map : result) {
			if (map.get("username").equals("admin")) {
				System.out.println(map);
			}
		}
		System.out.println(result);
		
		// ----------------------测试级联操作和删除------------------------
//		String HQL_DEL_SUIT = "delete from UserSuit where username = :username and codeSuit = :codeSuit";
//		int result = EM.getEntityManager().createQuery(HQL_DEL_SUIT)
//				.setParameter("username", "user")
//				.setParameter("codeSuit", "wHat01")
//				.executeUpdate();
//		EM.getEntityManager().getTransaction().commit();
//		System.out.println(result);
		
		// ----------------测试级联操作和更新------------------
//		String HQL_UPDATE_SUIT = "update UserSuit set zIndex = :zIndex where username = :username and codeSuit = :codeSuit";
//		int result = EM.getEntityManager().createQuery(HQL_UPDATE_SUIT)
//				.setParameter("zIndex", 1)
//				.setParameter("username", "admin")
//				.setParameter("codeSuit", "mShoe02")
//				.executeUpdate();
//		EM.getEntityManager().getTransaction().commit();
//		System.out.println(result);
		
		// --------------------测试一键导入---------------------
		// System.out.println(jsonType);
//		ImportUtil.addAllDataType(JSONStringToJSONArray.getJSONArray(jsonType.toString().replaceAll("编号", "code").replaceAll("名称", "name")));
//		ImportUtil.addAllDataSuit(JSONStringToJSONArray.getJSONArray(
//				jsonType.toString().replaceAll("编号", "code").replaceAll("名称", "name").
//				replaceAll("价格", "price").replaceAll("性别", "sex").replaceAll("分类", "type").replace("图片", "image")));
		
	}
	
}
