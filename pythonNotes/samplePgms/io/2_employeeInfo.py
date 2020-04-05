import csv

with open('employee_info.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            print(f'Column names are {", ".join(row)}')
            line_count += 1
        else:
            print(f'\t{row[0]} is the employee name, having {row[1]} as the user id and {row[2]} as a password.')
            line_count += 1
    print(f'Processed {line_count} lines.')


