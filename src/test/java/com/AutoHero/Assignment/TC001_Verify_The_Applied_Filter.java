/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.AutoHero.Assignment;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.AutoHero.Assignment.gui.pages.HomePage;
import com.AutoHero.Assignment.gui.pages.VehicleDetails;
import com.AutoHero.Assignment.utils.Utils;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.Priority;
import com.qaprosoft.carina.core.foundation.utils.tag.TestPriority;



public class TC001_Verify_The_Applied_Filter implements IAbstractTest {
    
	
	@Test(dataProvider = "SingleDataProvider")
    @MethodOwner(owner = "Pranit Jadhav")
    @TestPriority(Priority.P1)
    @TestLabel(name = "feature", value = {"web", "regression"})
	@XlsDataSourceParameters(path = "xls/TestData.xlsx", sheet = "AutoHero", dsUid = "TUID", testRailColumn = "Brand")
    public void VerifyTheFilter(HashMap<String,String> objTestData) throws Exception {
     
		HomePage ObjHomePage = new HomePage(getDriver());
		ObjHomePage.open();
		ObjHomePage.getAcceptCookies().click();
		ObjHomePage.getCarSelection();
		ObjHomePage.getBrandName().click();												// We can also parameterized this step
		ObjHomePage.getModelName().click();
		ObjHomePage.getMileageFilter().click();
		ObjHomePage.getDD().select(2);

        Utils.zoomOut();																//Zoomout to avoid Lazy loading issue
       
       	List<VehicleDetails> V = new ArrayList<>();  
		int iTotalRecords =  ObjHomePage.getCarName().size();
		
		 for (int i = 0; i < iTotalRecords ; i++)
		 {   
			 V.add(new VehicleDetails(ObjHomePage.getCarName().get(i).getText(), Integer.parseInt(ObjHomePage.getCarMileage().get(i).getText().replaceAll("[^0-9]", ""))));
		 }
		
		 SoftAssert ObjAssert=  new SoftAssert();												
		 ObjAssert.assertEquals(V.stream().filter(V1 -> V1.getMileage()<25000).collect(Collectors.toList()).size(), iTotalRecords, "Records Mismatched");
		 ObjAssert.assertEquals(V.stream().filter(V1 -> V1.getVehicleName().contains(objTestData.get("Brand"))).collect(Collectors.toList()).size(),iTotalRecords,"Name Mismatched");	
		 ObjAssert.assertAll();
			
		
		}

    }


