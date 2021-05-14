package hust.soict.khmt.test.media;

import hust.soict.khmt.aims.media.Book;

public class TestBook {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		String content = "Once upon a time there was a dear little girl who was loved by every one who looked at her, but most of all by her grandmother, and there was nothing that she would not have given to the child. Once she gave her a little cap of red velvet, which suited her so well that she would never wear anything else. So she was always called Little Red Riding Hood.\r\n"
				+ "\r\n"
				+ "One day her mother said to her, \"Come, Little Red Riding Hood, here is a piece of cake and a bottle of wine. Take them to your grandmother, she is ill and weak, and they will do her good. Set out before it gets hot, and when you are going, walk nicely and quietly and do not run off the path, or you may fall and break the bottle, and then your grandmother will get nothing. And when you go into her room, don't forget to say, good-morning, and don't peep into every corner before you do it.\"";

		Book story = new Book();
		story.setTitle("Little Read Riding Hood");
		story.addAuthor("Wilhelm Grimm");
		story.addAuthor("Jacob Grimm");
		story.setCategory("Fairy Tales");
		story.setCost(1000000);
		story.setContent(content);
		System.out.println(story.toString());
	}
}
