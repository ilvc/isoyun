package me.ilvc.yunso.novel.model;


import me.ilvc.yunso.utils.String2Unicode;

public class UNovelChapter extends NovelChapter{

	
	

	@Override
	public void setChapterId(Integer id) {
		super.setChapterId(id);
	}

	@Override
	public void setNovelname(String novelname) {
		String tmp = String2Unicode.string2Unicode(novelname);
		super.setNovelname(tmp);
	}

	@Override
	public void setChaptername(String chaptername) {
		String tmp =String2Unicode.string2Unicode(chaptername);
		super.setChaptername(tmp);
	}

	@Override
	public void setContent(String content) {
		String tmp =String2Unicode.string2Unicode(content);
		super.setContent(tmp);
	}

	@Override
	public void setChapterurl(String chapterurl) {
		String tmp =String2Unicode.string2Unicode(chapterurl);
		super.setChapterurl(tmp);
	}

	@Override
	public void setNovelnum(String novelnum) {
		// TODO Auto-generated method stub
		super.setNovelnum(novelnum);
	}

	@Override
	public void setChapternum(Integer chapternum) {
		// TODO Auto-generated method stub
		super.setChapternum(chapternum);
	}

	@Override
	public String toString() {
		return "UNovelChapter{} " + super.toString();
	}
}
