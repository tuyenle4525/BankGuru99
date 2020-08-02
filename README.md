# BankGuru99

## Instalation
Chromedriver version 84.0.4147.30 [download](https://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/)

Google chorme version 84

## Running the test
Open lib folder -> right click runTestcase.xml -> Run As -> 1 TestNG Suite

## Configuration 
Open runTestcase.xml file
- **Run single browser** 
```python
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="false">
  <test name="run for chrome">
  <parameter name = "browser" value = "chrome" />
    <classes>
    	<class name="bankGuru99.bankGuru99Testcase"/>
    </classes>
  </test>
</suite> 	

```
- **Run multiple browser** 
```python
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="false">
  <test name="run for firefox">
  <parameter name = "browser" value = "firefox" />
    <classes>
    	<class name="bankGuru99.bankGuru99Testcase"/>
    </classes>
  </test>
  
  <test name="run for chrome">
  <parameter name = "browser" value = "chrome" />
    <classes>
    	<class name="bankGuru99.bankGuru99Testcase"/>
    </classes>
  </test>
</suite> 	

```

- **Run parallel browser** *(parallel="tests" thread-count="2")*
```python

<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" parallel="tests" thread-count="2">
  <test name="run for firefox">
  <parameter name = "browser" value = "firefox" />
    <classes>
    	<class name="bankGuru99.bankGuru99Testcase"/>
    </classes>
  </test>
  
  <test name="run for chrome">
  <parameter name = "browser" value = "chrome" />
    <classes>
    	<class name="bankGuru99.bankGuru99Testcase"/>
    </classes>
  </test>
</suite> 	


```

