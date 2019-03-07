import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { first } from 'rxjs/operators';

import { UserService } from '../user.service';

@Component({
    selector: 'login',
    templateUrl: './login.component.html'
})

export class LoginComponent implements OnInit {

    model: any = {};
    registerForm: any;
    loading = false;
    submitted = false;


    constructor(
        private route: ActivatedRoute,
        private userService: UserService,
        private router: Router,
        private http: HttpClient
    ) { }

    ngOnInit() {
        sessionStorage.setItem('token', '');
    }

    // convenience getter for easy access to form fields
    get f() { return this.registerForm.controls; }

    login() {
        const url = 'http://localhost:8080/api/login';
        this.http.post<Observable<boolean>>(url, {
            name: this.model.username,
            password: this.model.password
        }).subscribe(isValid => {
            if (isValid) {
                sessionStorage.setItem('token', btoa(this.model.username + ':' + this.model.password));
                this.router.navigate(['home']);
            } else {
                alert('Authentication failed.');
                this.router.navigate(['login']);
            }
        });
    }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        console.log('SUBMITTING');
        this.userService.register(this.registerForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.router.navigate(['/login']);
                },
                error => {
                    this.loading = false;
                });
    }
}
