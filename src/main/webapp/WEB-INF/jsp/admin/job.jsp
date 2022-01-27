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
                <th class="px-4 py-3">Tên công việc</th>
                <th class="px-4 py-3">Số lượng</th>
                <th class="px-4 py-3">Địa chỉ làm việc</th>
                <th class="px-4 py-3">Trạng thái</th>
                <th class="px-4 py-3">Ngày đăng</th>
                <th class="px-4 py-3">Ngày hết hạn</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
            <c:forEach items="${jobs}" var="job">
                <tr class="text-gray-700 dark:text-gray-400">
                    <td class="px-4 py-3 text-sm">${job.name}</td>
                    <td class="px-4 py-3 text-sm">${job.number}</td>
                    <td class="px-4 py-3 text-sm">${job.address}</td>
                    <td class="px-4 py-3 text-sm">${job.jobStatus.name}</td>
                    <td class="px-4 py-3 text-sm">${job.postdate}</td>
                    <td class="px-4 py-3 text-sm">${job.expiredate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <tag-adminPageable:adminPageable currentPage="${currentPage}" totalPage="${totalPage}" size="${jobs.size()}" total="${total}"/>
</div>