package com.example.helpers;

public enum ApiService {
	
	LOGIN_SERVICES_LOGIN("login_services/login"),
	POSITION_CATALOG_GETALL("position_catalog/getall"),
	POSITION_CATALOG_GETBYID("position_catalog/getById"),
	POSITION_CATALOG_INSERT("position_catalog/insert"),
	POSITION_CATALOG_GETBYNAME("position_catalog/getByName"),
	POSITION_CATALOG_DELETEBYID("position_catalog/deleteById"),
	POSITION_CATALOG_UPDATE("position_catalog/update"),
	POSITION_CATALOG_CHANGESTATUS("position_catalog/changeStatus"),
	STATUS_CATALOG_GETALL("status_catalog/getAll"),
	STATUS_CATALOG_GETBYID("status_catalog/getById"),
	STATUS_CATALOG_GETBYNAME("status_catalog/getByName"),
	STATUS_EMPLOYEE_CATALOG_GETALL("status_employee_catalog/getAll"),
	STATUS_EMPLOYEE_CATALOG_GETBYID("status_employee_catalog/getById"),
	STATUS_EMPLOYEE_CATALOG_GETBYNAME("status_employee_catalog/getByName"),
	STATUS_EMPLOYEE_CATALOG_INSERT("status_employee_catalog/insert"),
	STATUS_EMPLOYEE_CATALOG_DELETEBYID("status_employee_catalog/deleteById"),
	STATUS_EMPLOYEE_CATALOG_UPDATE("status_employee_catalog/update"),
	COUNTRY_SERVICE_GETALL("country_service/getall"),
	COUNTRY_SERVICE_INSERT("country_service/insert"),
	COUNTRY_SERVICE_GETBYID("country_service/getById"),
	COUNTRY_SERVICE_GETBYNAME("country_service/getByName"),
	COUNTRY_SERVICE_CHANGESTATUS("country_service/changeStatus"),
	COUNTRY_SERVICE_UPDATE("country_service/update"),
	STATUS_PURCHASE_CATALOG_GETALL("status_purchase_catalog/getAll"),
	STATUS_PURCHASE_CATALOG_GETBYID("status_purchase_catalog/getById"),
	STATUS_PURCHASE_CATALOG_GETBYNAME("status_purchase_catalog/getByName"),
	STATUS_PURCHASE_CATALOG_INSERT("status_purchase_catalog/insert"),
	STATUS_PURCHASE_CATALOG_DELETEBYID("status_purchase_catalog/deleteById"),
	STATUS_PURCHASE_CATALOG_UPDATE("status_purchase_catalog/update"),
	ENDPOINT_SERVICE_GETALL("endpoint_service/getAll"),
	ENDPOINT_SERVICE_GETBYID("endpoint_service/getById"),
	ENDPOINT_SERVICE_GETBYNAME("endpoint_service/getByName"),
	ENDPOINT_SERVICE_INSERT("endpoint_service/insert"),
	ENDPOINT_SERVICE_CHANGESTATUS("endpoint_service/changeStatus"),
	ENDPOINT_SERVICE_UPDATE("endpoint_service/update"),
	ENDPOINT_SERVICE_GETBYSAMENAME("endpoint_service/getBySameName"),
	PERMISSION_SERVICE_INSERT("permission_service/insert"),
	PERMISSION_SERVICE_GETBYIDEMPLOYEE("permission_service/getByIdEmployee"),
	PERMISSION_SERVICE_SEARCHBYIDCOMPOUND("permission_service/searchByIdCompound"),
	PERMISSION_SERVICE_INSERTCOLLECTION("permission_service/insertCollection"),
	PERMISSION_SERVICE_DELETEBYID("permission_service/deleteById");

	
	protected String resource;
	protected String endpoint = "http://10.138.96.28:8080/wineservices/index.php/";
	protected String url;
	
	private ApiService(String resource) {
		this.resource = resource;
		url = endpoint + this.resource;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getUrl() {
		return url;
	}
}