import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture
def browser():
    driver = webdriver.Chrome() 
    yield driver
    driver.quit()

def test_verify_homepage_title(browser):
    # Launch URL and verify the title of the page
    browser.get("http://the-internet.herokuapp.com/")
    assert "The Internet" in browser.title

def test_verify_checkboxes_page(browser):
    # Click on Checkboxes link and verify the text on the page
    print("Before clicking on Checkboxes link..")
    checkbox_link = WebDriverWait(browser, 10).until(
        EC.element_to_be_clickable((By.LINK_TEXT, "Checkboxes"))
    )
    
    checkbox_link.click()
    print("After clicking on Checkboxes link")
    assert "Checkboxes" in browser.find_element(By.TAG_NAME, "h3").text

    # Verify checkbox 1 is not checked and checkbox 2 is checked
    assert not is_checkbox_checked(browser, 1)
    assert is_checkbox_checked(browser, 2)

def test_verify_file_upload(browser):
    # Click on File Upload link and verify the text on the page
    file_upload_link = WebDriverWait(browser, 10).until(
    EC.element_to_be_clickable((By.LINK_TEXT, "File Upload"))
    )

    file_upload_link.click()
    browser.back()

    # Click on File Upload link and verify the text on the page
    browser.find_element(By.LINK_TEXT, "File Upload").click()
    assert "File Uploader" in browser.find_element(By.TAG_NAME, "h3").text

    # Click on Choose File button to select the file
    file_input = browser.find_element(By.ID, "file-upload")
    file_input.send_keys("C:/Users/sivaj/PythonCaptest/test_Pytestss.txt")

    # Click on Upload button
    browser.find_element(By.ID, "file-submit").click()

def is_checkbox_checked(browser, index):
    checkboxes = browser.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
    return checkboxes[index - 1].is_selected()

if __name__ == "__main__":
    pytest.main(["-v", "test_Pytestss.py"])
