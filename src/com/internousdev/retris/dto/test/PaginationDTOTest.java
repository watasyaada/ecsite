package com.internousdev.retris.dto.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.internousdev.retris.dto.PaginationDTO;
import com.internousdev.retris.dto.ProductInfoDTO;

public class PaginationDTOTest {

	//get TotalPageSize test

	@Test
	public void testGetTotalPageSizeNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetTotalPageSizeNo2() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetTotalPageSizeNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}


	//set TotalPageSize test

	@Test
	public void testSetTotalPageSizeNo1(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetTotalPageSizeNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetTotalPageSizeNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setTotalPageSize(expected);
		int actual = dto.getTotalPageSize();
		assertEquals(expected,actual);
	}

	// get CurrentPageNo test


	@Test
	public void testGetCurrentPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetCurrentPageNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);


	}


	@Test
	public void testGetCurrentPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);
	}

	// set CurrentPageNo test

	@Test
	public void testSetCurrentPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetCurrentPageNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetCurrentPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setCurrentPageNo(expected);
		int actual = dto.getCurrentPageNo();
		assertEquals(expected,actual);
	}





	// get totalRecordSize test

	@Test
	public void testGetTotalRecordSizeNo1() {
	   PaginationDTO dto = new PaginationDTO();
	   int expected =0;

	   dto.setTotalRecordSize(expected);
	   int actual = dto.getTotalRecordSize();
	   assertEquals(expected,actual);
	}

	@Test
	public void testGetTotalRecordSizeNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setTotalRecordSize(expected);
		int actual = dto.getTotalRecordSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetTotalRecordSizeNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setTotalRecordSize(expected);
		int actual = dto.getTotalRecordSize();
		assertEquals(expected,actual);
	}




	// set totalRecordSize test

	@Test
	public void testSetTotalRecordSizeNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setTotalRecordSize(expected);
		int actual = dto.getTotalRecordSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetTotalRecordSizeNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setTotalRecordSize(expected);
		int actual = dto.getTotalRecordSize();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetTotalRecordSizeNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setTotalRecordSize(expected);
		int actual = dto.getTotalRecordSize();
		assertEquals(expected,actual);
	}



	// get StartRecordNo test

	@Test
	public void testGetStartRecordNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetStartRecordNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetStartRecordNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);
	}




	// set SetStartRecordNo test

	@Test
	public void testSetStartRecordNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);

	}

	@Test
	public void testSetStartRecordNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetStartRecordNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setStartRecordNo(expected);
		int actual = dto.getStartRecordNo();
		assertEquals(expected,actual);
	}




	// get EndRecordNo test

	@Test
	public void testGetEndRecordNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);

	}

	@Test
	public void testGetEndRecordNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetEndRecordNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);
	}

	// set EndRecordNo test

	@Test
	public void testSetEndRecordNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);

	}

	@Test
	public void testSetEndRecordNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetEndRecordNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setEndRecordNo(expected);
		int actual = dto.getEndRecordNo();
		assertEquals(expected,actual);
	}

	// get PageNumberList test

	@Test
	public void testGetPageNumberList() {
	    List<Integer> actualList = new ArrayList<Integer>();
	    actualList.add(10);
	    actualList.add(20);
	    actualList.add(30);
	    actualList.add(40);
	    actualList.add(50);
	    assertThat(actualList.get(0),equalTo(10));
	}

	// set PageNumberList test

	@Test
	public void testSetPageNumberList() {
		List<Integer> actualList = new ArrayList<Integer>();
		actualList.add(10);
		actualList.add(20);
		actualList.add(30);
		actualList.add(40);
		actualList.add(50);
		assertThat(actualList.get(0),equalTo(10));
	}

	// get CurrentProductInfoPage test

	@Test
	public void testGetCurrentProductInfoPage() {
		List<ProductInfoDTO> expected = new ArrayList<>();
		ProductInfoDTO expectedDto = new ProductInfoDTO();
		for(int i=0; i<=100; i+=10){
			expectedDto.setId(i);
			expected.add(expectedDto);
		}

		List<ProductInfoDTO> actual =new ArrayList<>();
		ProductInfoDTO actualDto = new ProductInfoDTO();
		for(int i=0; i<=100; i+=10){
			actualDto.setId(i);
			actual.add(actualDto);
		}

		assertThat(actual.get(0).getId(),equalTo(expected.get(0).getId()));

	}

	//set CurrentProductInfoPage test

	@Test
	public void testSetCurrentProductInfoPage() {
		List<ProductInfoDTO> expected = new ArrayList<>();
		ProductInfoDTO expectedDto = new ProductInfoDTO();
		for(int i=0; i<=100; i+=10){
			expectedDto.setId(i);
			expected.add(expectedDto);
		}

		List<ProductInfoDTO> actual = new ArrayList<>();
		ProductInfoDTO actualDto = new ProductInfoDTO();
		for(int i=0; i<=100; i+=10){
			actualDto.setId(i);
			actual.add(actualDto);
		}
	}

	// is NextPage test

	//true

	@Test
	public void testIsNextPage1() {
		PaginationDTO dto = new PaginationDTO();
		boolean expected = true;
		dto.setNextPage(expected);
		assertEquals(expected,dto.isNextPage());
	}

	@Test
	public void testSetNextPage1(){
		PaginationDTO dto = new PaginationDTO();
		boolean expected = true;
		dto.setNextPage(expected);
		assertEquals(expected,dto.isNextPage());
	}


	//false

	@Test
	public void testIsNextPage2(){
		PaginationDTO dto = new PaginationDTO();
		boolean expected = false;
		dto.setNextPage(expected);
		assertEquals(expected,dto.isNextPage());
	}

	@Test
	public void testSetNextPage2(){
		PaginationDTO dto = new PaginationDTO();
		boolean expected = false;
		dto.setNextPage(expected);
		assertEquals(expected,dto.isNextPage());
	}


	//is PreviousPage test

	//Test

	@Test
	public void testIsPreviousPage1() {
		PaginationDTO dto = new PaginationDTO();
		boolean expected = true;
		dto.setPreviousPage(expected);
		assertEquals(expected,dto.isPreviousPage());
	}

	@Test
	public void testSetPreviousPage1() {
		PaginationDTO dto = new PaginationDTO();
		boolean expected = true;
		dto.setPreviousPage(expected);
		assertEquals(expected,dto.isPreviousPage());
	}

	// false

	@Test
	public void testIsPreviousPage2(){
		PaginationDTO dto = new PaginationDTO();
		boolean expected = false;
		dto.setPreviousPage(expected);
		assertEquals(expected,dto.isPreviousPage());
	}

	@Test
	public void testSetPreviousPage2() {
		PaginationDTO dto = new PaginationDTO();
		boolean expected = false;
		dto.setPreviousPage(expected);
		assertEquals(expected,dto.isPreviousPage());
	}

	//get NextPageNo test

	@Test
	public void testGetNextPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
	    int expected = 0;

	    dto.setNextPageNo(expected);
	    int actual = dto.getNextPageNo();
	    assertEquals(expected,actual);
	}

	@Test
	public void testGetNextPageNoNo2(){
		PaginationDTO dto  = new PaginationDTO();
		int expected = 2147483647;

		dto.setNextPageNo(expected);
		int actual = dto.getNextPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetNextPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setNextPageNo(expected);
		int actual = dto.getNextPageNo();
		assertEquals(expected,actual);

	}

	//set NextPageNo test

	@Test
	public void testSetNextPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setNextPageNo(expected);
		int actual = dto.getNextPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetNextPageNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setNextPageNo(expected);
		int actual = dto.getNextPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetNextPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setNextPageNo(expected);
		int actual = dto.getNextPageNo();
		assertEquals(expected,actual);
	}



	// get PreviousPageNo

	@Test
	public void testGetPreviousPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);

	}

	@Test
	public void testGetPreviousPageNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testGetPreviousPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);
	}

	// set PreviousPageNo

	@Test
	public void testSetPreviousPageNoNo1() {
		PaginationDTO dto = new PaginationDTO();
		int expected = 0;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetPreviousPageNoNo2(){
		PaginationDTO dto = new PaginationDTO();
		int expected = 2147483647;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);
	}

	@Test
	public void testSetPreviousPageNoNo3(){
		PaginationDTO dto = new PaginationDTO();
		int expected = -2147483648;

		dto.setPreviousPageNo(expected);
		int actual = dto.getPreviousPageNo();
		assertEquals(expected,actual);
	}

}
