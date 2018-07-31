/**
 *
 */
package com.internousdev.retris.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kycdada
 *
 */
public class CommonUtility {
	/**
	 * 16桁の乱数取得
	 * return 16桁の乱数
	 */
	public String getRandomValue(){
		//結果の初期化
		String value="";
		//乱数の受け皿のdouble型
		double d;
		//乱数取得開始(16桁)
		for(int i=0;i<16;i++){
			//0～1未満までの乱数掛ける10
			d=Math.random()*10;
			//1～9までの乱数dをStringの最後尾に追加
			value=value+(int)d;
		}
		return value;
	}

	/**
	 * 文字列を区切り文字にて分解
	 * return 分割後の文字列の配列
	 */
	public String[] parseArrayList(String s){
		//区切り文字としてカンマ+半角スペースを指定、最後の空白は配列に含めない
		return s.split(", ",0);
	}


	/**Listを指定したサイズごとに分割
	 *
	 * @param list 分割元のリスト
	 * @param size 分割単位
	 * @return サイズごとに分割されたlist。ただし、listがnullまたは空の場合、もしくはsizeが0以下の場合はnullを返す。
	 */
	public <E>List<List<E>> devideList(List<E> list,int size){
		//list内listが空もしくはnull、もしくはsizeが0以下の場合
		if(list==null || list.isEmpty() || size<=0){
			return null;
		}
		//返すlistの要素数(分割listの数)を求める。
		int block=list.size()/size +(list.size()%size>0 ? 1 : 0);
		//要素数を指定してインスタンス化
		List<List<E>> devidedList =new ArrayList<List<E>>(block);
		//list内listに要素を分ける。」
		for(int i=0;i<block;i++){
			//分ける要素の開始点
			int start=i*size;
			//分ける要素の終了点
			int end=Math.min(start + size, list.size());
			devidedList.add(new ArrayList<E>(list.subList(start, end)));
		}
		return devidedList;
	}
}
