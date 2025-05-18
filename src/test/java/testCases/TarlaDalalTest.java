package testCases;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import base.TestBase;
import pages.Scrape_All_Recipes_with_LFV_LCHF_with_FoodstoAvoid;
import pages.Search_Scrape_Recipes_with_LFV_LCHF;
import pages.TarladalalSearch;
import utilities.ExcelReader;
import utilities.PostgresqlQueries;

public class TarlaDalalTest extends TestBase {

	Connection conn = null;

	@Test
	public void scrapeRecipes() throws Exception {

		// Opens db connection and creates tables
		PostgresqlQueries dbQuries = new PostgresqlQueries(); 
		conn = dbQuries.createTables_list();

		// scrape recipes and insert into tables
		//TarladalalSearch searchscrape = new TarladalalSearch(driver.get(), conn, dbQuries);
		//Search_Scrape_Recipes_with_LFV_LCHF searchscrape = new Search_Scrape_Recipes_with_LFV_LCHF(driver.get(), conn, dbQuries);
		Scrape_All_Recipes_with_LFV_LCHF_with_FoodstoAvoid searchscrape = new Scrape_All_Recipes_with_LFV_LCHF_with_FoodstoAvoid(driver.get(), conn, dbQuries);
		searchscrape.scrapeAllRecipes();

		// close db connection
		dbQuries.closeConnection(conn);
	}
}
