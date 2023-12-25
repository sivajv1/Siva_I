# test_fixtures_2.py

import pytest

# Fixture for user data
@pytest.fixture
def user_data():
    return {
        "username": 'john_doe',
        "email": "john.doe@example.com",
        "password": "password123"
    }

# Fixture for product data
@pytest.fixture
def product_data():
    return {
        "product_name": "Test Product",
        "price": 19.99,
        "quantity": 100
    }

# Test function using user_data fixture
def test_user_registration(user_data):
    assert isinstance(user_data, dict)
    assert "username" in user_data
    assert "email" in user_data
    assert "password" in user_data
    # Add more specific tests related to user registration

# Test function using product_data fixture
def test_product_creation(product_data):
    assert isinstance(product_data, dict)
    assert "product_name" in product_data
    assert "price" in product_data
    assert "quantity" in product_data
    # Add more specific tests related to product creation
