package jp.sf.amateras.javalib.jgit;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.revwalk.RevCommit;


/**
 * JGitのサンプル
 * 
 * @author Naoki Takezoe
 */
public class JGitSample {

	public static void main(String[] args)  throws Exception {
		// リモートリポジトリをclone
		Git.cloneRepository()
			.setURI("https://github.com/takezoe/solr-scala-client.git")
			.setDirectory(new File("git"))
			.call();
		
		// ログを取得
		Iterable<RevCommit> logs = Git.open(new File("git")).log().call();
		for(RevCommit rev: logs){
			System.out.println(rev.getCommitterIdent().getEmailAddress() + " - " + rev.getCommitTime());
			System.out.println(rev.getFullMessage());
			System.out.println("--");
		}
		
		// diffを表示
		Git.open(new File("git")).diff().setOutputStream(System.out).call();
	}

}
