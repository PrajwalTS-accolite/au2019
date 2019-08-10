import { Injectable } from '@angular/core';
import Employee from '../assets/employees.json';
import Department from '../assets/department.json';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataserveService {

  private empList = Employee.Employees;
  private empBehaviourSubject = new BehaviorSubject(this.empList);
  empObservable = this.empBehaviourSubject.asObservable();

  private deptList = Department.Departments;
  private deptBehaviourSubject = new BehaviorSubject(this.deptList);
  deptObservable = this.deptBehaviourSubject.asObservable();


  getEmpList(){
    return this.empList;
  }

  setEmpList(value:any){
    this.empBehaviourSubject.next(value);
  }

  retrieveEmpFromId(id:number){
    return this.empList.find(
      function(elem){
        return elem.id == id;
      }
    );
  }

  getDeptList(){
    return this.deptList;
  }

  setDeptList(value:any){
    this.deptBehaviourSubject.next(value);
  }

  retrieveDeptFromId(id:number){
    return this.deptList.find(
      function(elem){
        return elem.id == id;
      }
    );
  }

  constructor() { }
}
