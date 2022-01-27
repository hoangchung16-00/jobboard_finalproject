<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="tag-adminPageable" tagdir="/WEB-INF/tags"%>
<!-- With avatar -->
<h4 class="mb-4 text-lg font-semibold text-gray-600 dark:text-gray-300">Danh sách nhà tuyển dụng</h4>
<!-- Divs are used just to display the examples. Use only the button. -->

<div class="w-full mb-8 overflow-hidden rounded-lg shadow-xs">
    <div class="w-full overflow-x-auto">
        <table class="w-full whitespace-no-wrap">
            <thead>
            <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                <th class="px-4 py-3">Nhà tuyển dụng</th>
                <th class="px-4 py-3">Địa chỉ</th>
                <th class="px-4 py-3">Website</th>
                <th class="px-4 py-3">Email</th>
                <th class="px-4 py-3">SĐT</th>
                <th class="px-4 py-3"></th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
            <c:forEach items="${companies}" var="company">
                <tr class="text-gray-700 dark:text-gray-400">
                    <td class="px-4 py-3">
                        <div class="flex items-center text-sm">
                            <!-- Avatar with inset shadow -->
                            <div class="relative hidden w-8 h-8 mr-3 rounded-full md:block">
                                <img class="object-cover w-full h-full rounded-full" src="/image/${company.image}" alt="" loading="lazy"/>
                                <div class="absolute inset-0 rounded-full shadow-inner" aria-hidden="true"></div>
                            </div>
                            <div>
                                <p class="font-semibold">${company.name}</p>
                                <p class="text-xs text-gray-600 dark:text-gray-400">From: ${company.foundationyear}</p>
                            </div>
                        </div>
                    </td>
                    <td class="px-4 py-3 text-sm">${company.address}</td>
                    <td class="px-4 py-3 text-xs"><a href="${company.website}" target="_blank">${company.website}</a></td>
                    <td class="px-4 py-3 text-sm">${company.email}</td>
                    <td class="px-4 py-3 text-sm">${company.phonenumber}</td>
                    <td class="px-4 py-3 text-sm"><a class="btn btn-primary" href="/admin/job/${company.id}">View Job</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <tag-adminPageable:adminPageable currentPage="${currentPage}" totalPage="${totalPage}" size="${companies.size()}" total="${total}"/>
</div>