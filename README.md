## Giới thiệu:
- ✍ Môn học: Lập trình WWW (Java)
- ✍ Chủ đề: Bài tập tuần 07
<br />

## Đề bài:
<img src="img/Screenshot 2023-11-29 203045.png"/>
<br />

## Bài làm:
I. Trang web cho khách hàng
<p></p>
1. Trang Home
<p></p>
- ✍ Trang hiển thị danh sách tất cả các sản phẩm trừ các sản phẩm có trạng thái là TERMINATED
<p></p>
- ✍ Những sản phẩm có trạng thái là IN_ACTIVE sẽ có nhãn dán là tạm ngưng
<p></p>
- ✍ Danh sách sản phẩm đang mặc định được sắp xếp theo bán chạy nhất sẽ xuất hiện trên đầu
<p></p>
- ✍ Có phân trang sản phẩm với mỗi trang hiển thị tối đa 10 sản phẩm
<p></p>
- ✍ Giá sản phẩm là giá mới nhất trong danh sách giá của sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 200223.png"/>
<img src="img/Screenshot 2023-11-29 200312.png"/>
<img src="img/Screenshot 2023-11-29 200336.png"/>
- ✍ Khi chọn tên một thương hiệu (hoặc nhà xuất bản) bên thanh navbar bên cạnh sẽ lọc ra những hiển thị của thương hiệu đó để hiển thị
<p></p>
<img src="img/Screenshot 2023-11-29 200359.png"/>
<img src="img/Screenshot 2023-11-29 200418.png"/>
- ✍ Có thể chọn sắp xếp danh sách sản phẩm theo giá từ thấp đến cao hoặc cao đến thấp
<p></p>
<img src="img/Screenshot 2023-11-29 200509.png"/>
<img src="img/Screenshot 2023-11-29 200529.png"/>
- ✍ Khi chọn vào ô search sẽ hiển thị danh sách tên của sản phẩm (chỉ hiển một số lượng tên hạn chế vì đã set chiều cao cho thẻ div này)
<p></p>
- ✍ Có chức năng gợi ý tên theo keywork người dùng nhập vào
<p></p>
<img src="img/Screenshot 2023-11-29 200611.png"/>
<img src="img/Screenshot 2023-11-29 200632.png"/>
- ✍ Giao diện giỏ hàng khi chưa có sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 200700.png"/>
2. Trang chi tiết sản phẩm
<p></p>
- ✍ Hiển thị danh sách hình ảnh của sản phẩm có thể đổi sang hình khác để xem
<p></p>
<img src="img/Screenshot 2023-11-29 200752.png"/>
<img src="img/Screenshot 2023-11-29 200810.png"/>
- ✍ Có thể chọn số lượng và thêm vào giỏ hàng
<p></p>
<img src="img/Screenshot 2023-11-29 200833.png"/>
- ✍ Giỏ hàng lúc này sẽ hiển thị sản phẩm vừa thêm vào và số lượng của nó
<p></p>
<img src="img/Screenshot 2023-11-29 200900.png"/>
- ✍ Có thể chọn xóa sản phẩm bất kì trong giỏ hàng
<p></p>
<img src="img/Screenshot 2023-11-29 200923.png"/>
- ✍ Chọn đăng ký trên thanh navbar trên cùng sẽ hiển thị form đăng ký
<p></p>
<img src="img/Screenshot 2023-11-29 200948.png"/>
- ✍ Chọn đăng nhập sẽ hiển thị form đăng nhập
<p></p>
<img src="img/Screenshot 2023-11-29 201047.png"/>
- ✍ Khi đăng nhập thành công sẽ hiển thị tên người dùng trên thanh navbar và ẩn chức năng đăng nhập, đăng ký
<p></p>
<img src="img/Screenshot 2023-11-29 201116.png"/>
<img src="img/Screenshot 2023-11-29 201138.png"/>
- ✍ Khi đưa con trỏ tới tên người dùng sẽ hiển thị các chức năng dành cho người dùng
<p></p>
<img src="img/Screenshot 2023-11-29 201154.png"/>
3. Trang tài khoản của tôi
<p></p>
- ✍ Hiển thị thông tin của người dùng có thể cập nhật lại
<p></p>
<img src="img/Screenshot 2023-11-29 201216.png"/>
4. Trang đơn mua
<p></p>
- ✍ Hiển thị danh sách đơn hàng người dùng đã mua
<p></p>
<img src="img/Screenshot 2023-11-29 201240.png"/>
- ✍ Khi chọn logout sẽ hủy session và quay lại trang Home
<p></p>
<img src="img/Screenshot 2023-11-29 201304.png"/>
II. Trang web cho admin
<p></p>
1. Trang login
<p></p>
- ✍ Chỉ những tài khoản của nhân viên không có trạng thái TERMINATED mới đăng nhập được
<p></p>
<img src="img/Screenshot 2023-11-29 201322.png"/>
2. Trang thông tin nhân viên
<p></p>
- ✍ Khi đăng nhập thành công sẽ hiển thị trang thông tin nhân viên
<p></p>
- ✍ Có thể cập nhật được
<p></p>
- ✍ Đồng thời trên thanh navbar cũng hiển thị tên nhân viên
<p></p>
<img src="img/Screenshot 2023-11-29 201322.png"/>
- ✍ Khi đưa con trỏ vào tên nhân viên sẽ hiển thị các chức năng dành riêng cho nhân viên
<p></p>
<img src="img/Screenshot 2023-11-29 201409.png"/>
3. Trang danh sách sản phẩm 
<p></p>
- ✍ Hiển thị danh sách sản phẩm (trừ sản phẩm TERMINATED) được phân trang với các chức năng thêm, xóa, sửa,...
<p></p>
<img src="img/Screenshot 2023-11-29 201449.png"/>
<img src="img/Screenshot 2023-11-29 201505.png"/>
4. Trang chi tiết sản phẩm dành cho nhân viên
<p></p>
- ✍ Giống trang chi tiết dành cho khách hàng nhưng không có chức năng thêm vào giỏ hàng và mua hàng
<p></p>
<img src="img/Screenshot 2023-11-29 201527.png"/>
5. Trang hiển thị form sửa sản phẩm
<p></p>
- ✍ Hiển thị form thông tin sản phẩm muốn sửa
<p></p>
<img src="img/Screenshot 2023-11-29 201555.png"/>
- ✍ Sửa thành công sẽ quay lại trang danh sách sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 201624.png"/>
6. Trang hiển thị form thêm sản phẩm
<p></p>
- ✍ Hiển thị form thông tin cần thiết của sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 201642.png"/>
7. Trang danh sách hình ảnh của sản phẩm
<p></p>
- ✍ Hiển thị danh sách hình ảnh của sản phẩm với chức năng thêm, xóa
<p></p>
<img src="img/Screenshot 2023-11-29 201703.png"/>
8. Trang hiển thị form thêm hình ảnh sản phẩm
<p></p>
- ✍ Khi chọn thêm hình ảnh sẽ hiển thị form thông tin cần thiết của hình ảnh sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 201722.png"/>
- ✍ Thêm thành công sẽ quay lại trang danh sách sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 201748.png"/>
- ✍ Chọn xóa để xóa sản phẩm
<p></p>
<img src="img/Screenshot 2023-11-29 201800.png"/>
9. Trang thống kê đơn hàng
<p></p>
- ✍ Hiển thị ba loại thống kê đơn hàng
<p></p>
<img src="img/Screenshot 2023-11-29 201820.png"/>
<img src="img/Screenshot 2023-11-29 201849.png"/>
- ✍ Thống kê đơn hàng theo ngày
<p></p>
<img src="img/Screenshot 2023-11-29 201911.png"/>
<img src="img/Screenshot 2023-11-29 202109.png"/>
- ✍ Thống kê đơn hàng theo khoảng thời gian
<p></p>
<img src="img/Screenshot 2023-11-29 202130.png"/>
- ✍ Thống kê đơn hàng theo nhân viên và khoảng thời gian
<p></p>
<img src="img/Screenshot 2023-11-29 202202.png"/>
10. Trang vẽ biểu đồ giá sản phẩm
<p></p>
- ✍ Hiển thị combobox để chọn tên sản phẩm muốn vẽ biểu đồ 
<p></p>
<img src="img/Screenshot 2023-11-29 202357.png"/>
<img src="img/Screenshot 2023-11-29 202437.png"/>
- ✍ Chọn nút vẽ biểu đồ để hiển thị biểu đồ giá của sản phẩm đó
<p></p>
<img src="img/Screenshot 2023-11-29 202414.png"/>
- ✍ Chọn đăng xuất sẽ hủy session và quay lại trang login cho admin
<p></p>
<img src="img/Screenshot 2023-11-29 202453.png"/>
