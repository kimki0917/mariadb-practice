-- 서브쿼리(SUBQUERY) SQL

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*) from salaries where salary > (select avg(salary) from salaries where to_date='9999-01-01')
and to_date='9999-01-01';

-- 문제2.(x) 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 급여를 조회하세요.
-- 단 조회결과는 급여의 내림차순으로 정렬되어 나타나야 합니다. 

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 급여 많은 사원의 사번, 이름과 급여를 조회하세요 
#땡

 
select c.emp_no, concat(c.first_name,' ',c.last_name)as name, a.salary
from salaries a, dept_emp b,employees c, (select dept_no,avg(salary) as salary
from salaries a join dept_emp b on a.emp_no = b.emp_no
 where a.to_date='9999-01-01'
 group by dept_no) d
 where a.emp_no = c.emp_no
 and b.emp_no = c.emp_no
 and b.dept_no = d.dept_no
 and a.to_date='9999-01-01'
 and b.to_date='9999-01-01'
 and a.salary> d.salary
 order by c.emp_no desc;

#left 조인으로 다시

-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select x.emp_no,x.name,y.name,y.dept_name from (select d.emp_no, concat(d.first_name,' ',d.last_name) as name, e.dept_no from employees d left join dept_emp e on d.emp_no = e.emp_no where e.to_date='9999-01-01') x, (select a.dept_no, a.dept_name, b.emp_no, concat(c.first_name,' ',c.last_name) as name from departments a join dept_manager b join employees c on a.dept_no = b.dept_no and b.emp_no = c.emp_no
where b.to_date='9999-01-01') y
where x.dept_no=y.dept_no;

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 급여를 조회하고 급여순으로 출력하세요.

select a.emp_no,a.first_name,b.title,c.salary,d.dept_no from employees a join titles b join salaries c join dept_emp d join
(select y.dept_no, avg(x.salary) from salaries x join dept_emp y on x.emp_no= y.emp_no
where x.to_date='9999-01-01'
group by y.dept_no
order by avg(x.salary) desc
limit 1) e on a.emp_no = b.emp_no and b.emp_no = c.emp_no and a.emp_no = d.emp_no and d.dept_no = e.dept_no
where b.to_date='9999-01-01'
and c.to_date='9999-01-01'
order by salary asc;


-- 문제6.
-- 평균 급여가 가장 높은 부서는?
-- 부서이름, 평균급여 

select a.dept_name, b.salary from departments a join (select b.dept_no, avg(a.salary) as salary from salaries a join dept_emp b on a.emp_no = b.emp_no 
where a.to_date = '9999-01-01' and b.to_date='9999-01-01' group by b.dept_no order by avg(salary) desc limit 1) b on a.dept_no = b.dept_no;

-- 문제7.
-- 평균 급여가 가장 높은 직책?
-- 직책, 평균급여 

select avg(salary),title from salaries a join titles b on a.emp_no = b.emp_no
where a.to_date='9999-01-01'
and b.to_date= '9999-01-01'
group by title
order by avg(salary) desc limit 1;

-- 문제8.
-- 현재 자신의 매니저보다 높은 급여를 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 매니저 급여순으로 출력합니다.

select c.dept_name, concat(d.first_name,' ',d.last_name) as name , a.salary, b.managerName, b.salary 
from 
(select b.emp_no, c.dept_no , b.salary from salaries b join dept_emp c on b.emp_no = c.emp_no where b.to_date ='9999-01-01'
and c.to_date='9999_01_01') a 
join
 (select a.dept_no, a.emp_no, b.salary, concat(c.first_name,' ',c.last_name) as managerName from dept_manager a join salaries b join employees c on a.emp_no = b.emp_no and a.emp_no = c.emp_no
where a.to_date ='9999-01-01'
and b.to_date='9999-01-01') b 
join departments c 
join employees d 
on a.dept_no = b.dept_no and b.dept_no =c.dept_no and a.emp_no = d.emp_no
where a.salary>b.salary;

